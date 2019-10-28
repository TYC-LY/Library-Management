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
	private Reader tempReader;
	private long readerId;
	private String startDate;
	private String endDate;
	private String condition;											//用来保存下拉框名称
	private String content;

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
	
	public Reader getTempReader() {
		return tempReader;
	}

	public void setTempReader(Reader tempReader) {
		this.tempReader = tempReader;
	}

	/**
	 * @return the readerId
	 */
	public long getReaderId() {
		return readerId;
	}

	/**
	 * @param readerId the readerId to set
	 */
	public void setReaderId(long readerId) {
		this.readerId = readerId;
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

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
