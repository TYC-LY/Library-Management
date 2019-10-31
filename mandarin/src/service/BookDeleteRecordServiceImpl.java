package service;

import entity.BookDeleteRecord;
import java.util.List;

public class BookDeleteRecordServiceImpl extends BaseService<BookDeleteRecord> implements BookDeleteRecordService{
	
	public void createRecord(BookDeleteRecord bookDeleteRecord) {
		this.getDao().save(bookDeleteRecord);
	}
	
	public List<BookDeleteRecord> getRecord() {
		return this.getDao().findAll();
	}
}
