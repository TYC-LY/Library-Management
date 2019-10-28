package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import entity.Record;

public class RecordServiceImpl extends BaseService<Record> implements RecordService{

	@Override
	public void makeNew(Record record) {
		// TODO Auto-generated method stub
		
		//SimpleDateFormat bjsdf =   new SimpleDateFormat( "yyyy/MM/dd" );
		//bjsdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		//record.setBorrowDate(bjsdf.format(new Date()));
		record.setBorrowDate(new Date());
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); // 设置为当前时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1); // 设置为上一个月
		date = calendar.getTime();
		//record.setDeadline(bjsdf.format(date));
		record.setDeadline(date);
		
		record.setReturnDate(null);
		record.setPayState(false);
		record.setFineValue(0);
		record.setReservationState(false);
		record.setBorrowState(true);
		this.getDao().save(record);
	}

	@Override
	public Record getBorrowRecordByBookId(long tempId) {
		// TODO Auto-generated method stub
		Record record = this.getDao().getSingle("bookId", tempId);
		return record;
	}

	@Override
	public void updateReturnRecord(Record record) {
		// TODO Auto-generated method stub
		//SimpleDateFormat bjsdf =   new SimpleDateFormat( "yyyy/MM/dd" ); 
		//bjsdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		//record.setReturnDate(bjsdf.format(new Date()));
		record.setReturnDate(new Date());
		
		record.setPayState(false);
		record.setFineValue(0);
		record.setReservationState(false);
		record.setBorrowState(false);
		this.getDao().merge(record);
	}

	@Override
	public Record getRecordById(long id) {
		// TODO Auto-generated method stub
		Record record = this.getDao().getSingle("id", id);
		return record;
	}

	@Override
	public List<Record> viewFineListByDuration(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return this.getDao().findByDuration("returnDate", startDate, endDate, "payState", true, "returnDate");
	}

}
