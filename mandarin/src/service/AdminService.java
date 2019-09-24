package service;

import java.util.List;

import entity.Admin;
import entity.Librarian;

public interface AdminService {
	
	public Admin verify(String username, String password);
	
	public void register(Librarian librarian);
	
	public Librarian getLibrarianByUsername(String username);
	public List<Librarian> getAllLibrarian();
	public void mergeAdmin(Admin admin);
}
