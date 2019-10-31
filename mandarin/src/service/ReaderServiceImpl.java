package service;

import java.util.Date;
import java.util.List;

import entity.Reader;
import entity.Record;

public class ReaderServiceImpl extends BaseService<Reader> implements ReaderService {

	@Override
	public Reader verify(String phonenumber, String password) {
		Reader reader = this.getDao().getSingle("phoneNumber", phonenumber);
		if (reader == null) {
//			System.out.println("娌℃湁鍙栧嚭鏉ワ紒锛侊紒");
			return null;
		}
// 鍔犲瘑
//		String dealedPassword = Encrypt.encrypt(password + user.getSalt());
		if (reader.getPassword().equals(password)) {
			return reader;
		}
//		System.out.println("瀵嗙爜涓嶅锛侊紒锛 ");
		return null;
	}

	
	public  Reader find(String email) {
		Reader reader=this.getDao().getSingle("email", email);
		if (reader == null) {
		return null;
		}
		return reader;
		
	}
	
	public void merge(Reader reader) {
		this.getDao().save(reader);		
	}
	
	@Override
	public Reader verify(long id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reader getReaderById(long id) {
		Reader reader = this.getDao().getSingle("id", id);
		return reader;
	}

	@Override
	public Reader getReaderByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reader> getAllReader() {
		List<Reader> readers = this.getDao().findAll();
		return readers;
	}

	@Override
	public void mergeReader(Reader reader) {
		// TODO Auto-generated method stub
		this.getDao().merge(reader);
	}

	@Override
	public void pass(long id) {
		Reader reader = getReaderById(id);
		reader.setCheckState(true);
		this.getDao().merge(reader);
		
	}

	@Override
	public List<Reader> getReaderCheckStateIsFalse() {
		List<Reader> readers = this.getDao().findBy("checkState", false);
		return readers;
	}

	@Override
	public void register(Reader reader) {
		// TODO Auto-generated method stub
		reader.setBorrowBookNumber(0);
		reader.setCheckState(true);
		
		// modify time:2019.10.23
		// To make the date automatically created by local time
//		SimpleDateFormat bjsdf = new SimpleDateFormat( "yyyy-MM-dd  HH:mm:ss" );
//		bjsdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//		reader.setCreateDate(bjsdf.format(new Date()));
		reader.setCreateDate(new Date());
		reader.setFineState(false);
		reader.setRepeatpw("12345678");
		this.getDao().save(reader);
	}

	@Override
	public Reader confirmReaderAuthority(long readerId) {
		// TODO Auto-generated method stub
		Reader reader = this.getDao().getSingle("id", readerId);
		if (reader != null) {
			return reader;
		}
		
		// dangerous
		return null;
	}

	@Override
	public void updateReturnReader(Reader reader) {
		// TODO Auto-generated method stub
		reader.setBorrowBookNumber(reader.getBorrowBookNumber()-1);
		this.getDao().merge(reader);
	}

	@Override
	public List<Reader> viewReaderByDuration(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return this.getDao().findByDuration("createDate", startDate, endDate, null, null, "createDate");
	}

	@Override
	public Reader searchReader(String condition, String content) {
		// TODO Auto-generated method stub
		return this.getDao().getSingle(condition, content);
	}

	@Override
	public void editReader(Reader reader) {
		// TODO Auto-generated method stub
		this.getDao().merge(reader);
	}

	@Override
	public void deleteReaderById(long id) {
		// TODO Auto-generated method stub
		this.getDao().delete(id);
	}
	
}
