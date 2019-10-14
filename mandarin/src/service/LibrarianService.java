package service;

import java.util.List;

import entity.Librarian;
import entity.Reader;

public interface LibrarianService {

	public Librarian verify(String username, String password);
	
	public void register(Reader reader);
	
	// ͼ��ݹ���Ա�ܹ��ڳ��ܵİ������һ����룬����ȷ���������Ӧ����admin�л�����service��
	public boolean checkEmail(String email);
	
	public Librarian getLibrarianById(long id);
	
	public List<Librarian> getAllUsers();
	public void mergeLibrarian(Librarian librarian);

	public Librarian verifySecurityQuestion(String username, String securityAnswer);
}
