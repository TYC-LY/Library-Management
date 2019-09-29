package action;

import java.util.List;

import entity.Reader;
import service.ReaderService;

public class ReaderAction extends BaseAction<Reader, ReaderService> {

	private static final long serialVersionUID = 1L;

	private Reader Reader;

	private List<Reader> Readers;

	public String signup() throws Exception{
    	String username = this.getModel().getUsername();
    	String phoneNumber = this.getModel().getPhoneNumber();
    	String email = this.getModel().getEmail();
    	String password = this.getModel().getPassword();
    	if(password.isEmpty()) {
    		this.errorMessage="password can not be empty";
    		return INPUT;
    	}
    	else if(username.isEmpty()) {
    		this.errorMessage="username can not be empty";
    		return INPUT;
    	}
    	else if(email.isEmpty()) {
    		this.errorMessage="email can not be empty";
    		return INPUT;
    	}
    	else if(phoneNumber.isEmpty()) {
    		this.errorMessage="phoneNumber can not be empty";
    		return INPUT;
    	}
    	try {
			this.getService().register(this.getModel());
		}
		catch (Exception ex){
			this.addActionError(ex.getMessage());
			this.errorMessage="failure";
			return INPUT;
		}
    	this.errorMessage="success";
    	return SUCCESS;
    }
	
	public String pass() {
		long id = this.getModel().getId();
		this.getService().pass(id);
		return SUCCESS;
	}

	public String checkReader() {
		this.Readers = this.getService().getReaderCheckStateIsFalse();
		return SUCCESS;
	}

	public Reader getReader() {
		return Reader;
	}

	public void setReader(Reader reader) {
		Reader = reader;
	}

	public List<Reader> getReaders() {
		return Readers;
	}

	public void setReaders(List<Reader> readers) {
		Readers = readers;
	}
}
