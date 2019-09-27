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
}
