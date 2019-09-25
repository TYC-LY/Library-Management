package service;

import entity.Reader;

public interface ReaderService {

	Reader verify(String email, String password);

}
