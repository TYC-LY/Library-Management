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
}
