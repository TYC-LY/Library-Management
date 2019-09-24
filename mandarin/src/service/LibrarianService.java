package service;

import java.util.List;

import entity.Librarian;
import entity.Reader;

public interface LibrarianService {

	public Librarian verify(long id, String password);
	
	public void register(Reader reader);
	
	// 图书馆管理员能够在超管的帮助下找回密码，但不确定这个服务应该在admin中还是在service中
	public boolean checkEmail(String email);
	
	public Reader getReaderById(long id);
	
	public List<Reader> getAllUsers();
	public void mergeReader(Reader reader);
}
