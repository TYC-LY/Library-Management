package action;

import entity.BookDeleteRecord;
import entity.Librarian;
import service.BookDeleteRecordService;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class BookDeleteRecordAction extends BaseAction<BookDeleteRecord, BookDeleteRecordService>{
	
	private List<BookDeleteRecord> records;

	public String addRecord() throws Exception{
		Map<String, Object> session = ActionContext.getContext().getSession();
		Librarian librarian = (Librarian)session.get("librarian");
		if(librarian == null) {
			this.errorMessage = "You need to login the librarian account";
			return INPUT;
		}
		// 設置librarianId
		this.getModel().setLibrarianId(librarian.getId());
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
