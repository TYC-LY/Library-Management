package service;

import java.util.List;

import entity.Librarian;
import entity.Reader;

public class LibrarianServiceImpl extends BaseService<Librarian> implements LibrarianService {

	@Override
	public Librarian verify(String username, String password) {
		Librarian librarian = this.getDao().getSingle("username", username);
		if (librarian == null) {
			return null;
		}
		if (librarian.getPassword().equals(password)) {
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
		Librarian librarian = this.getDao().getSingle("id", id);
		return librarian;
	}

	@Override
	public void mergeLibrarian(Librarian librarian) {
		// TODO Auto-generated method stub
		this.getDao().merge(librarian);
	}

	@Override
	public List<Librarian> getAllUsers() {
		// TODO Auto-generated method stub
		return this.getDao().findAll();
	}

	public Librarian verifySecurityQuestion(String username, String securityAnswer) {
		Librarian librarian = this.getDao().getSingle("username", username);
		if (librarian == null) {
			return null;
		}
		if (librarian.getSecurityAnswer().equals(securityAnswer)) {
			return librarian;
		}
		return null;
	}

	@Override
	public void check(long id) {
		Librarian librarian = getLibrarianById(id);
		librarian.setCheckState(true);
		this.getDao().merge(librarian);
	}

	@Override
	public List<Librarian> getLibrarianCheckStateIsFalse() {
		List<Librarian> librarian = this.getDao().findBy("checkState", false);
		return librarian;
	}

	public Librarian checkUsername(String username) {
		Librarian librarian = this.getDao().getSingle("username", username);
		return librarian;// 检查是否已有该用户名
	}

	public Librarian checkID(long id) {
		Librarian librarian = this.getDao().getSingle("id", id);
		return librarian;// 检查是否已有该用户
	}

	public void addLibrarian(Librarian librarian) {
		this.getDao().save(librarian);
	}// 添加管理员用户

	public void delectLibrarian(Librarian librarian) {
//		Librarian librarian = this.getDao().getSingle("username", username);
//		librarian.setPassword("00010001");
//		librarian.setUsername("0000000000000000");
//		this.getDao().save(librarian);
		this.getDao().delete(librarian);
	}// 删除管理员用户(实则没有，至少让用户名查不到了罢了)

	public void changeLibrarian(long id, String username) {
		Librarian librarian = this.getDao().getSingle("id", id);
		librarian.setUsername(username);
		this.getDao().save(librarian);
	}// 编辑管理员信息

	public Librarian search(String username) {
		Librarian librarian = this.getDao().getSingle("username", username);
		return librarian;
	}// 查找特定的管理员信息

	@Override
	public String[] getAllUsername(int i) {
		String a = "";
		String username = null;
		Librarian librarian = null;
		long c = 1;
		for (int e = 0; e < i; e++) {
			librarian = this.getDao().getSingle("id", c);
			username = librarian.getUsername();
			a += username;
			if (e != i - 1)
				a += ",";
			c = c + 1;
		}
		String[] answer = a.split(",");
		return answer;
	}

	@Override
	public int count() {
		long id = 1;
		int time = 0;
		Librarian librarian = this.checkID(id);
		while (librarian != null) {
			id = id + 1;
			time = time + 1;
			librarian = this.checkID(id);
		}
		return time;
	}

	@Override
	public Librarian getLibrarianByUsername(String username) {
		Librarian librarian = this.getDao().getSingle("username", username);
		return librarian;
	}

}
