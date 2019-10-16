package action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import entity.Reader;
import service.ReaderService;
import utils.BarCodeUtils;

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
    	
    	long id = this.getModel().getId();
		
		String idString = String.valueOf(id);
		// 生成barcode
		try {
			BufferedImage image = BarCodeUtils.insertWords(BarCodeUtils.getBarCode(idString), idString);
			ImageIO.write(image, "jpg", new File("D://barcode_reader//" + idString + ".jpg"));
		} catch (IOException ioex) {
			this.addActionError(ioex.getMessage());
			this.errorMessage = "failure to create the barcode";
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
