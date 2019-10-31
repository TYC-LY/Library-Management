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

	private String content_reader = null;
	private String contactemail = null;

	private Reader tempReader_reader;
	private String searchContent;
	public static String emailforchangepassword;
	
	
	
	//
	private Reader Reader;
	private List<Reader> Readers;
	private Reader tempReader;
	private long readerId;
	private String startDate;
	private String endDate;
	private String condition;											//用来保存下拉框名称
	private String content;
	
	public static void set(String test) {
		emailforchangepassword = test;
		System.out.println(emailforchangepassword);
	}
	public String signin() throws Exception {
		String phonenumber = this.getModel().getPhoneNumber();
		String password = this.getModel().getPassword();
		
		System.out.println(phonenumber);
		System.out.println(password);
		if(phonenumber == null) {
			this.errorMessage="Please enter your phonenumber!";
			return INPUT;
		}
		if(password == null) {
			this.errorMessage="Please enter your password";
			return INPUT;
		}
		Reader reader = this.getService().verify(phonenumber, password);
		if (reader != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("reader", reader);
			setTempReader(reader);
			this.errorMessage="Login successfully";
			return SUCCESS;
		}
		this.errorMessage="Wrong phonenumber or password";
		return INPUT;
	}

	public String login() throws Exception {
		return SUCCESS;
	}

	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		System.out.println("***" + ActionContext.getContext().getSession().get("reader") + "***");
		return SUCCESS;
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
		Reader reader = (Reader) session.get("reader");
		String username=this.getModel().getUsername();
		String email=this.getModel().getEmail();
		String password=this.getModel().getPassword();
		String repeatpw=this.getModel().getRepeatpw();
		String phoneNumber=this.getModel().getPhoneNumber();
		if (password.equals(repeatpw) == false) {
			System.out.println(password);
			System.out.println(repeatpw);
			System.out.println("aaaaaaaaaaaaaaaaa");
			return INPUT;
		}
		reader.setUsername(username);
		reader.setEmail(email);
		reader.setPassword(password);
		reader.setRepeatpw(repeatpw);
		reader.setPhoneNumber(phoneNumber);
		this.getService().merge(reader);
		System.out.println("bbbbbbbbb");
		return SUCCESS;
	}

	public String reset() throws AddressException, MessagingException {
		set(this.getModel().getEmail());
		if (emailforchangepassword == null) {
			this.errorMessage = "Please enter your email!";
			return INPUT;
		}
		mail.main(emailforchangepassword, "You are applying to change your password, if the application is deliverd by yourself, please click the following link to accomplite http://localhost:8080/mandarin/changePassword.jsp, if not please ignore this email","Recovery Your Password");

		return SUCCESS;

	}

	public String changeEmail() throws AddressException, MessagingException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String email = this.getModel().getEmail();
		if (email == null) {
			this.errorMessage = "Please enter your email!";
			return INPUT;
		}
		Reader reader = (Reader) session.get("reader");
		reader.setEmail(email);
		this.getService().merge(reader);
		return SUCCESS;
	}



	public String changePassword() throws AddressException, MessagingException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String password = this.getModel().getPassword();
		if (password == null) {
			this.errorMessage = "Please enter your password!";
			return INPUT;
		}
		System.out.println(emailforchangepassword);
		Reader reader = this.getService().find(emailforchangepassword);
		reader.setPassword(password);
		mail.main(emailforchangepassword, "Your passowrd has been changed and the new password is "+ password +", if the action is not operated by youself, please log in the system and change your password", "Your password has been changed");
		this.getService().merge(reader);
		set(null);
		return SUCCESS;
	}

	public String changeUsername() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader reader = (Reader) session.get("reader");
		String username = this.getModel().getUsername();
		if (username == null) {
			this.errorMessage = "Please enter your username!";
			return INPUT;
		}
		reader.setUsername(username);
		this.getService().merge(reader);
		return SUCCESS;
	}

	public String changePhoneNumber() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader reader = (Reader) session.get("reader");
		String phoneNumber = this.getModel().getPhoneNumber();
		if (phoneNumber == null) {
			this.errorMessage = "Please enter your phoneNumber!";
			return INPUT;
		}
		reader.setPhoneNumber(phoneNumber);
		this.getService().merge(reader);
		return SUCCESS;
	}
	
	public String SendMessage() throws AddressException, MessagingException {	
		System.out.print(this.contactemail);
		System.out.print(this.content_reader);
		mail.main("huoying8.11@qq.com","from " + this.contactemail + ": " + this.content_reader,"Contact us Message");		
		return SUCCESS;

	}

	// searchContent
	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	

	public String getContactemail() {
		return contactemail;
	}
	
	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}
	public String getContent_reader() {
		return content_reader;
	}
	public void setContent_reader(String content_reader) {
		this.content_reader = content_reader;
	}
	public Reader getTempReader_reader() {
		return tempReader_reader;
	}
	public void setTempReader_reader(Reader tempReader_reader) {
		this.tempReader_reader = tempReader_reader;
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
	public Reader getTempReader() {
		return tempReader;
	}
	public void setTempReader(Reader tempReader) {
		this.tempReader = tempReader;
	}
	public long getReaderId() {
		return readerId;
	}
	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
	public String signup() throws Exception {
		String username = this.getModel().getUsername();
		String phoneNumber = this.getModel().getPhoneNumber();
		String email = this.getModel().getEmail();
		String password = this.getModel().getPassword();
		if (password.isEmpty()) {
			this.errorMessage = "password can not be empty";
			return INPUT;
		} else if (username.isEmpty()) {
			this.errorMessage = "username can not be empty";
			return INPUT;
		} else if (email.isEmpty()) {
			this.errorMessage = "email can not be empty";
			return INPUT;
		} else if (phoneNumber.isEmpty()) {
			this.errorMessage = "phoneNumber can not be empty";
			return INPUT;
		}
		//try {
			this.getService().register(this.getModel());
//		} catch (Exception ex) {
//			this.addActionError(ex.getMessage());
//			this.errorMessage = "failure";
//			return INPUT;
//		}

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

		this.errorMessage = "success";
		return SUCCESS;
	}
//
//	public String pass() {
//		long id = this.getModel().getId();
//		this.getService().pass(id);
//		return SUCCESS;
//	}
//
//	public String checkReader() {
//		this.Readers = this.getService().getReaderCheckStateIsFalse();
//		return SUCCESS;
//	}

	// borrow books
	public String borrow_FindReader() {
		readerId = this.getReaderId();
		// System.out.println(readerId);
		Reader reader = this.getService().confirmReaderAuthority(readerId);
		if (reader != null) {
			return SUCCESS;
		}
		this.errorMessage = "It's a wrong ID of reader.";
		return INPUT;
	}

	// update reader data after borrowing
	public String borrow_ReaderUpdate() {
		tempReader = this.getService().getReaderById(readerId);
		int bookNumberNow = tempReader.getBorrowBookNumber();
		if(tempReader.getBorrowBookNumber() >= 3) {
			this.errorMessage = "Your have borrowed three books. You can not lend any book.";
			return INPUT;
		}
		if(tempReader.isFineState() == true ) {
			this.errorMessage = "You have not paid for the fine of the book.";
			return INPUT;
		}
		tempReader.setBorrowBookNumber(bookNumberNow + 1);
		this.getService().mergeReader(tempReader);
		return SUCCESS;
	}

	// update reader data after returning
	public String return_ReaderUpdate() {
		readerId = this.getReaderId();
		try {
			tempReader = this.getService().getReaderById(readerId);
			this.getService().updateReturnReader(tempReader);
		} catch(Exception e1) {
			this.errorMessage = "It is the wrong Id of reader. or This account may have been deleted.";
			return INPUT;
		}
		this.errorMessage = "You succeed in returning the book";
		return SUCCESS;
	}
	
	public String viewDeposit() {
		this.startDate = this.getStartDate();
		this.endDate = this.getEndDate();
		
		Readers = this.getService().viewReaderByDuration(startDate,endDate);
		
		return SUCCESS;
	}


	public String readerManagement_Search() throws Exception {
		condition = this.getCondition();
		content = this.getContent();
		if(content.isEmpty()) {
			this.errorMessage = "no input";
			return INPUT;	
		}
		else {
			if(condition.equals("id")){
				readerId = Long.parseLong(content);
				tempReader = this.getService().getReaderById(readerId);
			}
			else tempReader = this.getService().searchReader(condition, content);
		}
		if (tempReader != null) {
			this.errorMessage = "success";
			return SUCCESS;
		}
		this.errorMessage = "fail to get a reader";
		return INPUT;
		
	}

	public String readerManagement_Edit() {
		tempReader = this.getModel();
		try {
			this.getService().editReader(tempReader);
		}catch(Exception e2) {
			this.errorMessage = "failed to edit";
			return INPUT;
		}
		this.errorMessage = "success";
		return SUCCESS;
	}
	
	public String readerManagement_Delete() throws Exception{
		int borrowBookNumber = this.getModel().getBorrowBookNumber();
		boolean fineState = this.getModel().isFineState();
		
		//System.out.println(borrowBookNumber);
		//System.out.println(fineState);
		
		if(fineState == true && borrowBookNumber != 0){
			this.errorMessage = "The reader needs to pay the fine and return all the books.";
			return INPUT;
		}else if(fineState == true){
			this.errorMessage = "The reader needs to pay the fine.";
			return INPUT;
		}else if(borrowBookNumber != 0){
			this.errorMessage = "The reader needs to return all the books.";
			return INPUT;
		}
			
		System.out.println(this.getModel().getId()); //获取不到readerId
		this.getService().deleteReaderById(this.getModel().getId());
			
		this.errorMessage = "success";
		return SUCCESS;
	}
}
