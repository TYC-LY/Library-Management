package service;

import java.util.List;

import entity.Reader;

public interface ReaderService{
	
	public Reader verify(long id, String password);
	
	public boolean checkEmail(String email);
	
	public Reader getReaderById(long id);
	
	public Reader getReaderByEmail(String email);
	public List<Reader> getAllReader();
	public void mergeReader(Reader reader);
	
	public void pass(long id);

	public List<Reader> getReaderCheckStateIsFalse();

	public void register(Reader reader);

	public Reader confirmReaderAuthority(long readerId);

	public void updateReturnReader(Reader reader);

	public List<Reader> viewReaderByDuration(String startDate, String endDate);
	
	public Reader searchReader(String condition, String content);
	
	public void editReader(Reader reader);
	
	public void deleteReaderById(long id);
}
