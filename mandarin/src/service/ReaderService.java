package service;

import entity.Reader;

public interface ReaderService {

	public Reader verify(String email, String password);
}
