package action;


import entity.Record;
import service.RecordService;


public class RecordAction extends BaseAction<Record, RecordService> {
	
	private static final long serialVersionUID = 1L;
	
	private Record tempRecord;
	
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
	
	public Record getTempRecord() {
		return tempRecord;
	}

	public void setTempRecord(Record tempRecord) {
		this.tempRecord = tempRecord;
	}
}
