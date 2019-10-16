package service;

import entity.BookDeleteRecord;
import java.util.List;

public interface BookDeleteRecordService {
	
	public void createRecord(BookDeleteRecord bookDeleteRecord);
	
	public List<BookDeleteRecord> getRecord();

}
