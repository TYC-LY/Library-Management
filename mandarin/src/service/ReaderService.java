package service;

import entity.Reader;

public interface ReaderService {

	public Reader verify(String email, String password);
	public boolean checkEmail(String email);
	public void register(Reader reader);
}
