package action;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.opensymphony.xwork2.ActionContext;

import entity.Reader;
import entity.Record;
import service.ReaderService;

import utils.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class ReaderAction extends BaseAction<Reader, ReaderService> {

	private static final long serialVersionUID = 1L;

	private Reader tempReader;
	private String searchContent;

	public String signin() throws Exception {
		String email = this.getModel().getEmail();
		String password = this.getModel().getPassword();
		
		if(email == null) {
			this.errorMessage="Please enter your email!";
			return INPUT;
		}
		if(password==null) {
			this.errorMessage="???????";
			return INPUT;
		}
		Reader reader = this.getService().verify(email, password);
		if (reader != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("reader", reader);
			setTempReader(reader);
			return SUCCESS;
		}
		this.errorMessage="////////";
		return INPUT;
	}
	
	public String login() throws Exception{
		return SUCCESS;
	}
	public String logout() throws Exception{
		ActionContext.getContext().getSession().clear();
		System.out.println("***" + ActionContext.getContext().getSession().get("reader") + "***");
		return SUCCESS;
	}
	
	// zhao hai tang de signin
//	public String signin() throws Exception {
//		String email = this.getModel().getEmail();
//		String password = this.getModel().getPassword();
//		if (email == null) {
//			this.errorMessage = "Please enter your email!";
//			return INPUT;
//		}
//		if (password == null) {
//			this.errorMessage = "Please enter your password!";
//			return INPUT;
//		}
//		Reader reader = this.getService().verify(email, password);
//		if (reader != null) {
//			Map<String, Object> session = ActionContext.getContext().getSession();
//			session.put("reader", reader);
//			setTempReader(reader);
//			return INPUT;
//		}
//		this.errorMessage = "Your email or password is wrong!";
//		return INPUT;
//	}

	public String search() throws Exception {
		if (this.searchContent == null) {
			return NONE;
		}
		System.out.println(searchContent);
		return "isTitle";
//		if(searchContent.length()>=7  && searchContent.substring(0,7).equals("@email ")) {
//			String emailString = this.searchContent.substring(7).strip();
//			this.tempUser = this.getService().getUserByEmail(emailString);
//			if(this.tempUser==null) {
//				return NONE;
//			}
//			else {
//				Map<String, Object> session = ActionContext.getContext().getSession();
//		    	User user = (User) session.get("user");
//		    	if(user==null) {
//		    		return INPUT;
//		    	}
//				return "isuser";
//			}
//		}
//		else{
//			return "istheme";		
//		}
	}

	public String currentBorrowed() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader reader = (Reader) session.get("reader");
		if (reader != null) {
			System.out.println(reader.getId());
			return SUCCESS;
		} else {
			return "signin";
		}
	}

	public String borrowHistory() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader reader = (Reader) session.get("reader");
		if (reader != null) {
			System.out.println(reader.getId());
			return SUCCESS;
		} else {
			return "signin";
		}
	}
	
	// 更改信息
	public String changeInfo() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader temReader = (Reader) session.get("reader");
		String email = this.getModel().getEmail();
		String password = this.getModel().getPassword();
		String repeatpw = this.getModel().getRepeatpw();
		if (email.isEmpty()) {
			return INPUT;
		} else if (password != repeatpw) {
			return INPUT;
		}
		temReader.setEmail(email);
		temReader.setPassword(password);
		temReader.setRepeatpw(repeatpw);
		// TODO
		return SUCCESS;
	}

	public String reset() throws AddressException, MessagingException {
		String email = this.getModel().getEmail();
		if (email == null) {
			this.errorMessage = "Please enter your email!";
			return INPUT;
		}
		mail.main(email);
		Reader reader = this.getService().find(email);
		reader.setPassword("123456");
		this.getService().merge(reader);
		return SUCCESS;

	}

	// tempReader
	public Reader getTempReader() {
		return tempReader;
	}

	public void setTempReader(Reader tempReader) {
		this.tempReader = tempReader;
	}

	// searchContent
	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

}
