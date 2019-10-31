package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import entity.Reader;
import entity.Record;
import service.RecordService;

public class RecordAction extends BaseAction<Record, RecordService> {

	private static final long serialVersionUID = 1L;
	private List<Record> recordTable;
	private List<Record> currentTable;
	private List<Record> historyTable;
	
	//
	private Record tempRecord;
	private List<Record> fineList;
	private String startDate;
	private String endDate;
	private List<Record> records = new ArrayList<Record>();
	private long readerId;

	public String getCurrentBorrowed() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader reader = (Reader) session.get("reader");
		setRecordTable(this.getService().getRecordByReader(reader));
		currentTable = new ArrayList<Record>();
		for (int i = 0; i < recordTable.size(); i++) {
			if (recordTable.get(i).getReturnDate() == null && recordTable.get(i).getBorrowState() == true && recordTable.get(i).getReturnDate() == null) {
				currentTable.add(recordTable.get(i));
			}
		}
		return INPUT;
	}
	
	public String getBorrowHistory() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader reader = (Reader) session.get("reader");
		setRecordTable(this.getService().getRecordByReader(reader));
		historyTable = new ArrayList<Record>();
		for (int i = 0; i < recordTable.size(); i++) {
			if (recordTable.get(i).getReturnDate() != null && recordTable.get(i).getBorrowState() == true && recordTable.get(i).getReturnDate() != null) {
				historyTable.add(recordTable.get(i));
			}
		}
		return INPUT;
	}

	// recordTable
	public List<Record> getRecordTable() {
		return recordTable;
	}

	public void setRecordTable(List<Record> recordTable) {
		this.recordTable = recordTable;
	}

	// currentTable
	public List<Record> getCurrentTable() {
		return currentTable;
	}

	public void setCurrentTable(List<Record> currentTable) {
		this.currentTable = currentTable;
	}

	// historyTable
	public List<Record> getHistoryTable() {
		return historyTable;
	}

	public void setHistoryTable(List<Record> historyTable) {
		this.historyTable = historyTable;
	}

	public Record getTempRecord() {
		return tempRecord;
	}

	public void setTempRecord(Record tempRecord) {
		this.tempRecord = tempRecord;
	}

	public List<Record> getFineList() {
		return fineList;
	}

	public void setFineList(List<Record> fineList) {
		this.fineList = fineList;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public long getReaderId() {
		return readerId;
	}

	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}
	
	
	
	
	
	
	public String makeNewRecord() {
		//System.out.println("go to here");
		this.getService().makeNew(this.getModel());
    	return SUCCESS;
	}

	public String searchBorrowRecord_Lend()  {
		long tempId = this.getModel().getBookId();
		//System.out.println(tempId);
		this.tempRecord = this.getService().getBorrowRecordByBookId(tempId);
		// 不明白当时为什么加上这一句？
		// 原因：复制searchBorrowRecord方法时，忘记删除这一句
		//this.getService().updateReturnRecord(tempRecord);
		return SUCCESS;
	}
	
	public String searchBorrowRecord()  {
		long tempId = this.getModel().getBookId();
		//System.out.println(tempId);
		this.tempRecord = this.getService().getBorrowRecordByBookId(tempId);
		if(tempRecord == null) {
			this.errorMessage = "This book has not been borrowed.";
			return INPUT;
		}
		// 不应该在此处更新书的借阅状态
		//this.getService().updateReturnRecord(tempRecord);
		
		// zht添加试一试
		this.getService().updateReturnRecord(tempRecord);
		return SUCCESS;
	}
	
	//update record data after returning
	public String return_RecordUpdate(){
		long id = this.getModel().getId();
		tempRecord = this.getService().getRecordById(id);
		if(tempRecord.getFineValue() != 0 && tempRecord.getPayState() == false) {
			this.errorMessage = "You need to pay for the fine.";
			return INPUT;
		}
		// 设置书的状态为未借出
		this.getService().updateReturnRecord(tempRecord);
		this.errorMessage = "success";
		return SUCCESS;
	}
	
	public String viewFineValue() {
		this.startDate = this.getStartDate();
		this.endDate = this.getEndDate();
		
		this.fineList = this.getService().viewFineListByDuration(startDate,endDate);
		
		return SUCCESS;
	}
	
	public String searchBorrowRecords() {
		
		try {
				this.records = this.getService().getRecordByReaderId(this.getModel().getReaderId());
				if(this.records.isEmpty()){
					this.errorMessage = "There is no related reader, or there is no history of this reader.";
				}
		}
		catch(Exception e1) {
			this.errorMessage = "It is the wrong Id of record. or This record may have been deleted.";
			return INPUT;
		}
		
		return SUCCESS;
	}
	
	public String clearFine() {
		
		this.getService().clearFineById(this.getModel().getId());
		return SUCCESS;
		
	}
}
