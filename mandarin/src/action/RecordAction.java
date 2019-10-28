package action;


import java.util.ArrayList;
import java.util.List;

import entity.Record;
import service.RecordService;


public class RecordAction extends BaseAction<Record, RecordService> {
	
	private static final long serialVersionUID = 1L;
	
	private Record tempRecord;
	private List<Record> fineList;
	private String startDate;
	private String endDate;
	private List<Record> records = new ArrayList<Record>();
	private long readerId;
	
	public String makeNewRecord() {
		//System.out.println("go to here");
		this.getService().makeNew(this.getModel());
    	return SUCCESS;
	}

	public String searchBorrowRecord_Lend()  {
		long tempId = this.getModel().getBookId();
		//System.out.println(tempId);
		this.tempRecord = this.getService().getBorrowRecordByBookId(tempId);
		this.getService().updateReturnRecord(tempRecord);
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
		this.getService().updateReturnRecord(tempRecord);
		return SUCCESS;
	}
	
	//update record data after returning
	public String return_RecordUpdate(){
		long id = this.getModel().getId();
		tempRecord = this.getService().getRecordById(id);
		if(tempRecord.getFineValue() != 0 && tempRecord.isPayState() == false) {
			this.errorMessage = "You need to pay for the fine.";
			return INPUT;
		}
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

	public Record getTempRecord() {
		return tempRecord;
	}

	public void setTempRecord(Record tempRecord) {
		this.tempRecord = tempRecord;
	}

	/**
	 * @return the fineList
	 */
	public List<Record> getFineList() {
		return fineList;
	}

	/**
	 * @param fineList the fineList to set
	 */
	public void setFineList(List<Record> fineList) {
		this.fineList = fineList;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the readerId
	 */
	public long getReaderId() {
		return readerId;
	}

	/**
	 * @param readerId the readerId to set
	 */
	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}

	/**
	 * @return the records
	 */
	public List<Record> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(List<Record> records) {
		this.records = records;
	}
}
