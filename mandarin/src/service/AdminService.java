package service;

import java.util.List;

import entity.Admin;
import entity.Librarian;

public interface AdminService {

	public Admin verify(long id, String password);

	public Admin verify(String usename, String password);

	public void register(Librarian librarian);

	public Librarian getLibrarianById(long id);

	public List<Librarian> getAllLibrarian();

	public void mergeAdmin(Admin admin);

	public void changePassword(String password);

	public void ModifyFine(int fineValue);

	public int getValue();

	public void ModifyDeposit(int deposit1);

	public int getDeposit();

	public void ModifyPeriod(int period);

	public int getReturnPeriod();
}
