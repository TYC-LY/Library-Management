package service;

import java.util.List;

import entity.Librarian;
import entity.Reader;

public class LibrarianServiceImpl extends BaseService<Librarian> implements LibrarianService{

	@Override
	public Librarian verify(String username, String password) {
		Librarian librarian = this.getDao().getSingle("username", username);
		if(librarian == null) {
			return null;
		}
		if(librarian.getPassword().equals(password)){
			return librarian;
		}
		return null;
	}

	@Override
	public void register(Reader reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reader getReaderById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reader> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mergeReader(Reader reader) {
		// TODO Auto-generated method stub
		
	}

}
