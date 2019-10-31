package service;

import java.util.Date;
import java.util.List;

import entity.Reader;
import entity.Record;

public interface RecordService {

	List<Record> getRecordByReader(Reader reader);

	public void reserve(Record record);
	
	
	
	public void makeNew (Record record);

	public Record getBorrowRecordByBookId(long tempId);

	public void updateReturnRecord(Record record);

	public Record getRecordById(long id);

	public List<Record> viewFineListByDuration(String startDate, String endDate);
	
	public List<Record> getRecordByReaderId(long readerId);
	
	public void clearFineById(long id);

	List<Record> getRecordByDeadline(Date deadline);
}
