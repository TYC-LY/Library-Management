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
	public Librarian getLibrarianById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mergeLibrarian(Librarian librarian) {
		// TODO Auto-generated method stub
		this.getDao().merge(librarian);
	}

	@Override
	public List<Librarian> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public Librarian verifySecurityQuestion(String username, String securityAnswer) {
		Librarian librarian = this.getDao().getSingle("username", username);
		if(librarian == null) {
			return null;
		}
		if(librarian.getSecurityAnswer().equals(securityAnswer)){
			return librarian;
		}
		return null;
	}
}
