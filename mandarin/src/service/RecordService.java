package service;

import java.util.List;

import entity.Reader;
import entity.Record;

public interface RecordService {

	List<Record> getRecordByReader(Reader reader);

	public void reserve(Record record);

	List<Record> getRecordByDeadline(String deadline);
	
}
