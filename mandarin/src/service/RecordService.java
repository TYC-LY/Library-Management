package service;

import java.util.List;

import entity.Record;

public interface RecordService {

	public void makeNew (Record record);

	public Record getBorrowRecordByBookId(long tempId);

	public void updateReturnRecord(Record record);

	public Record getRecordById(long id);

	public List<Record> viewFineListByDuration(String startDate, String endDate);
}
