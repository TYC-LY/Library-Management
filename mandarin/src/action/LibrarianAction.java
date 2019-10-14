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
		String username = this.getModel().getUsername();
		String password = this.getModel().getPassword();
		System.out.println(username + password);
		if (username == null) {
			this.errorMessage = "Please enter your username";
			return INPUT;
		}
		if (password == null) {
			this.errorMessage = "Please enter your password";
			return INPUT;
		}
		Librarian librarian = this.getService().verify(username, password);
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
	

	public String answerSecurityQuestion() throws Exception {
		String username = this.getModel().getUsername();
		String securityAnswer = this.getModel().getSecurityAnswer();
		//System.out.println(username + securityAnswer);
		Librarian librarian = this.getService().verifySecurityQuestion(username, securityAnswer);
		if (librarian != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("librarian", librarian);
			return SUCCESS;
		}
		this.errorMessage = "Your answer is wrong!";
		return INPUT;
	}
	
	public String changePassword() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
    	tempLibrarian = (Librarian) session.get("librarian");
    	String password = this.getModel().getPassword();
		String repeatpw = this.getModel().getRepeatpw();
		if (password.equals(repeatpw)) {
			tempLibrarian.setPassword(password);
    	this.getService().mergeLibrarian(tempLibrarian);
    	return SUCCESS;
		}
		//System.out.println(password+repeatpw);
		this.errorMessage = "Please keep the same password!";
		return INPUT;
	}

	public String getTempLibrarianId() {
		return tempLibrarianId;
	}

	public void setTempLibrarianId(String tempLibrarianId) {
		this.tempLibrarianId = tempLibrarianId;
	}

	public Librarian getTempLibrarian() {
		return tempLibrarian;
	}

	public void setTempLibrarian(Librarian tempLibrarian) {
		this.tempLibrarian = tempLibrarian;
	}
	
}
