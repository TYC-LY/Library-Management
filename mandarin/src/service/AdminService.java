package service;

import java.util.List;

import entity.Admin;
import entity.Librarian;

public interface AdminService {
	
	public Admin verify(long id, String password);
	
	public void register(Librarian librarian);
	
	public Librarian getLibrarianById(long id);
	public List<Librarian> getAllLibrarian();
	public void mergeAdmin(Admin admin);
}
