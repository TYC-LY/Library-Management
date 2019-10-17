package service;

import java.util.List;

import entity.Reader;
import entity.Record;

public class RecordServiceImpl extends BaseService<Record> implements RecordService {

	@Override
	public List<Record> getRecordByReader(Reader reader) {
		List<Record> records = this.getDao().findBy("reader.id", reader.getId(), "borrowDate asc");
		return records;
	}
	
	public void reserve(Record record) {
		this.getDao().save(record);		
	}

}
