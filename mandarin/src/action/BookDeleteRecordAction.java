package action;

import entity.BookDeleteRecord;
import service.BookDeleteRecordService;
import java.util.List;

public class BookDeleteRecordAction extends BaseAction<BookDeleteRecord, BookDeleteRecordService>{
	
	private List<BookDeleteRecord> records;

	public String addRecord() throws Exception{
		
		this.getService().createRecord(this.getModel());
		return SUCCESS;
		
	}
	
	public String viewRecord() throws Exception{
		
		this.setRecords(this.getService().getRecord());
		return SUCCESS;
		
	}
	
	/**
	 * @return the records
	 */
	public List<BookDeleteRecord> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(List<BookDeleteRecord> records) {
		this.records = records;
	}


}
