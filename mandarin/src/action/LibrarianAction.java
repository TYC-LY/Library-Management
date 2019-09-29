package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Librarian;
import service.LibrarianService;

public class LibrarianAction extends BaseAction<Librarian, LibrarianService> {

	private static final long serialVersionUID = 1L;

	private Librarian tempLibrarian;
	private String tempLibrarianId;

	public String login() throws Exception {
		String librarianUsername = this.getModel().getUsername();
		String password = this.getModel().getPassword();
		System.out.println(librarianUsername + password);
		if (librarianUsername == null) {
			this.errorMessage = "Please enter your username";
			return INPUT;
		}
		if (password == null) {
			this.errorMessage = "Please enter your password";
			return INPUT;
		}
		Librarian librarian = this.getService().verify(librarianUsername, password);
		if (librarian != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("librarian", librarian);
			return SUCCESS;
		}
		this.errorMessage = "Your username or password is wrong";
		return INPUT;
	}

	public static String hasLogin() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Librarian librarian = (Librarian) session.get("librarian");
		if (librarian == null) {
			return INPUT;
		}
		return SUCCESS;
	}

	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
}
