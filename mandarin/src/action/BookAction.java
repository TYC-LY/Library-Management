package action;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.opensymphony.xwork2.ActionContext;

import entity.Book;
import entity.Record;
import service.BookService;
import utils.BarCodeUtils;
import utils.BookXMLParser;
import utils.FontImage;

public class BookAction extends BaseAction<Book, BookService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Book tempBook;
	private String url = "http://api.douban.com/book/subject/isbn/";
	private String apikey = "0b2bdeda43b5688921839c8ecb20399b";
	private String condition; // 用来保存下拉框名称
	private String content; // 用来保存下拉框内容
	private List<Book> books;
	private String pageState;
	private long tempBookId;
	private long book_copy_number;
	private List<BookCopy> idList;
	private BookCopy tempBookCopy;
	private long bookId;

	private List<Record> records;
	private List<BorrowInfo> payedFine = new ArrayList<BorrowInfo>();
	private List<BorrowInfo> unPayedFine = new ArrayList<BorrowInfo>();

	private class BorrowInfo {
		private long id;
		private long bookId;
		private long readerId;
		private String bookName;
		private int fineValue;
		private Date borrowDate;
		private Date deadline;
		private Date returnDate;
		private boolean payState;

		public BorrowInfo(long id, long bookId, long readerId, String bookName, int fineValue, Date borrowDate,
				Date deadline, Date returnDate, boolean payState) {
			super();
			this.id = id;
			this.bookId = bookId;
			this.readerId = readerId;
			this.bookName = bookName;
			this.fineValue = fineValue;
			this.borrowDate = borrowDate;
			this.deadline = deadline;
			this.returnDate = returnDate;
			this.payState = payState;
		}

		/**
		 * @return the id
		 */
		public long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(long id) {
			this.id = id;
		}

		/**
		 * @return the bookId
		 */
		public long getBookId() {
			return bookId;
		}

		/**
		 * @param bookId the bookId to set
		 */
		public void setBookId(long bookId) {
			this.bookId = bookId;
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

		/**
		 * @return the bookName
		 */
		public String getBookName() {
			return bookName;
		}

		/**
		 * @param bookName the bookName to set
		 */
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		/**
		 * @return the fineValue
		 */
		public int getFineValue() {
			return fineValue;
		}

		/**
		 * @param fineValue the fineValue to set
		 */
		public void setFineValue(int fineValue) {
			this.fineValue = fineValue;
		}

		/**
		 * @return the borrowDate
		 */
		public Date getBorrowDate() {
			return borrowDate;
		}

		/**
		 * @param borrowDate the borrowDate to set
		 */
		public void setBorrowDate(Date borrowDate) {
			this.borrowDate = borrowDate;
		}

		/**
		 * @return the deadline
		 */
		public Date getDeadline() {
			return deadline;
		}

		/**
		 * @param deadline the deadline to set
		 */
		public void setDeadline(Date deadline) {
			this.deadline = deadline;
		}

		/**
		 * @return the returnDate
		 */
		public Date getReturnDate() {
			return returnDate;
		}

		/**
		 * @param returnDate the returnDate to set
		 */
		public void setReturnDate(Date returnDate) {
			this.returnDate = returnDate;
		}

		/**
		 * @return the payState
		 */
		public boolean isPayState() {
			return payState;
		}

		/**
		 * @param payState the payState to set
		 */
		public void setPayState(boolean payState) {
			this.payState = payState;
		}

	}

	// 用于在BookMangement_Add_Books_Image界面显示对应的id
	private class BookCopy {
		private long idCopy;

		public BookCopy(long idCopy) {
			super();
			this.idCopy = idCopy;
		}

		public long getIdCopy() {
			return idCopy;
		}

		public void setIdCopy(long idCopy) {
			this.idCopy = idCopy;
		}
	}

	public String bookManagement_Find_Book_Detail() throws Exception {

		String ISBN = this.getModel().getISBN();
		String requestUrl = this.url + ISBN + "?apikey=" + this.apikey;

		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(requestUrl);
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		InputStream is = entity.getContent();
		this.tempBook = new BookXMLParser(is).getBook();

		if (tempBook.getTitle() == null) {
			tempBook.setTitle("null");
		}
		if (tempBook.getAuthor() == null) {
			tempBook.setAuthor("null");
		}
		if (tempBook.getPrice() == null) {
			tempBook.setPrice("null");
		}
		if (tempBook.getPublisher() == null) {
			tempBook.setPublisher("null");
		}
		if (tempBook.getISBN() == null) {
			tempBook.setISBN("null");
		}
		if (tempBook.getDescription() == null) {
			tempBook.setDescription("There is no description about the book.");
		}
		if (tempBook.getImagePath() == null) {
			tempBook.setImagePath("#");
		}

		return SUCCESS;
	}

	public String bookManagement_Add_Books() throws Exception {

		String ISBN = this.getModel().getISBN();
		String title = this.getModel().getTitle();
		String author = this.getModel().getAuthor();
		String publisher = this.getModel().getPublisher();
		String description = this.getModel().getDescription();
		String location_floor = this.getModel().getLocation_floor();
		String location_stack = this.getModel().getLocation_stack();
		String location_area = this.getModel().getLocation_area();
		String price = this.getModel().getPrice();
		String categoryNo = this.getModel().getCategoryNo();
		String imagePath = this.getModel().getImagePath();
		if (ISBN.isEmpty()) {
			this.errorMessage = "ISBN can not be empty";
			return INPUT;
		} else if (title.isEmpty()) {
			this.errorMessage = "title can not be empty";
			return INPUT;
		} else if (author.isEmpty()) {
			this.errorMessage = "author can not be empty";
			return INPUT;
		} else if (publisher.isEmpty()) {
			this.errorMessage = "publisher can not be empty";
			return INPUT;
		} else if (description.isEmpty()) {
			this.errorMessage = "description can not be empty";
			return INPUT;
		} else if (location_floor.isEmpty()) {
			this.errorMessage = "location_floor can not be empty";
			return INPUT;
		} else if (location_stack.isEmpty()) {
			this.errorMessage = "location_stack can not be empty";
			return INPUT;
		} else if (location_area.isEmpty()) {
			this.errorMessage = "location_area can not be empty";
			return INPUT;
		} else if (price.isEmpty()) {
			this.errorMessage = "price can not be empty";
			return INPUT;
		} else if (categoryNo.isEmpty()) {
			this.errorMessage = "categoryNo can not be empty";
			return INPUT;
		} else if (imagePath.isEmpty()) {
			this.errorMessage = "imagePath can not be empty";
		}

		// add book
		try {
			this.getService().addBook(this.getModel());
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("book", this.getModel());
			tempBook = this.getModel();
			this.idList = new ArrayList<BookCopy>();
			this.tempBookCopy = new BookCopy(tempBook.getId());
			idList.add(tempBookCopy);

			// test
			System.out.println(tempBook.getId());

		} catch (Exception ex) {
			this.addActionError(ex.getMessage());
			this.errorMessage = "failure";
			return INPUT;
		}

		long id = this.getModel().getId();

		String idString = String.valueOf(id);
		// 生成barcode
		try {
			BufferedImage image = BarCodeUtils.insertWords(BarCodeUtils.getBarCode(idString), idString);
			ImageIO.write(image, "jpg", new File("D://barcode//" + idString + ".jpg"));
		} catch (IOException ioex) {
			this.addActionError(ioex.getMessage());
			this.errorMessage = "failure to create the barcode";
		}

		String bookLocation = "floor " + this.getModel().getLocation_floor() + " stack "
				+ this.getModel().getLocation_stack() + " area " + this.getModel().getLocation_area();
		// 生成the image of the bookLoaction
		try {
			FontImage.createImage(bookLocation, new Font("Arial", Font.BOLD, 72),
					new File("d:/booklocation/" + idString + ".png"), bookLocation.length() * 40, 200);
		} catch (IOException ioex) {
			this.addActionError(ioex.getMessage());
			this.errorMessage = "failure to create the image of the book location";
		}

		this.errorMessage = "success";
		return SUCCESS;
	}

	public String bookManagement_Add_Books_Copy() throws Exception {

		this.book_copy_number = this.getBook_copy_number();
		this.idList = new ArrayList<BookCopy>();

		// 循环加入书本
		for (long i = 0; i <= book_copy_number; i++) {

			Map<String, Object> session = ActionContext.getContext().getSession();
			tempBook = (Book) session.get("book");
			ActionContext.getContext().getSession().clear();
			tempBook.setId(tempBook.getId() + 1);

			this.tempBookCopy = new BookCopy(tempBook.getId());
			idList.add(tempBookCopy);

			// borrowState reservationState在addBook(service)中设置
//			this.getModel().setAuthor(tempBook.getAuthor());
//			this.getModel().setCategoryNo(tempBook.getCategoryNo());
//			this.getModel().setDescription(tempBook.getDescription());
//			this.getModel().setISBN(tempBook.getISBN());
//			this.getModel().setLocation(tempBook.getLocation());
//			this.getModel().setPrice(tempBook.getPrice());
//			this.getModel().setPublisher(tempBook.getPublisher());
//			this.getModel().setTitle(tempBook.getTitle());

			// add book
			try {
				this.getService().addBookCopy(tempBook);

				Map<String, Object> session2 = ActionContext.getContext().getSession();
				session2.put("book", tempBook);
				//
//				tempBook = this.getModel();
			} catch (Exception ex) {
				this.addActionError(ex.getMessage());
				this.errorMessage = "failure";
				return INPUT;
			}

			long id = tempBook.getId();

			// 点击add copy之后，新增的书的id变为原书的id+1
			// 系统默认id为0
			// 设置id的值才能保证前端页面的src能找到对应的图片

			// 根据idString和bookLocation生成对应的条形码和图片
			String idString = String.valueOf(id);
			String bookLocation = "floor " + tempBook.getLocation_floor() + " stack " + tempBook.getLocation_stack()
					+ " area " + tempBook.getLocation_area();

			// 生成barcode
			try {
				BufferedImage image = BarCodeUtils.insertWords(BarCodeUtils.getBarCode(idString), idString);
				ImageIO.write(image, "jpg", new File("D://barcode//" + idString + ".jpg"));
			} catch (IOException ioex) {
				this.addActionError(ioex.getMessage());
				this.errorMessage = "failure to create the barcode";
			}

			// 生成the image of the bookLoaction
			try {
				FontImage.createImage(bookLocation, new Font("Arial", Font.BOLD, 72),
						new File("d:/booklocation/" + idString + ".png"), bookLocation.length() * 40, 200);
			} catch (IOException ioex) {
				this.addActionError(ioex.getMessage());
				this.errorMessage = "failure to create the image of the book location";
			}

		}

		this.errorMessage = "Succeed to add " + String.valueOf(book_copy_number) + " copy the book";
		return SUCCESS;
	}

	// SearchBook
	public String bookManagement_Search_Books() throws Exception {

		this.condition = this.getCondition();
		this.content = this.getContent();
		this.pageState = this.getPageState();

		// System.out.println(condition);
		// System.out.println(content);

		// if(condition == "ISBN") {
		// content = this.getModel().getISBN();
		// }
		// else if(condition == "title") {
		// content = this.getModel().getTitle();
		// }
		// else if(condition == "author") {
		// content = this.getModel().getAuthor();
		// }

		try {
			this.setBooks(this.getService().searchBook(condition, content));
		} catch (Exception ex) {
			this.addActionError(ex.getMessage());
			this.errorMessage = "failure";
			return INPUT;
		}
		if (pageState.equals("edit")) {
			return "edit";
		} else if (pageState.equals("delete")) {
			return "delete";
		}

		this.errorMessage = "success";
		return SUCCESS;

	}

	public String bookManagement_Detele_Books() throws Exception {

		boolean borrowState = this.getModel().isBorrowState();
		boolean reservationState = this.getModel().isReservationState();
//		
//		System.out.println(borrowState);
//		System.out.println(reservationState);
//		System.out.println(this.getModel().getTitle());
//		System.out.println(this.getModel().getISBN());
//		
		if (borrowState == false && reservationState == false) {
			this.getService().deleteBookById(this.getTempBookId());
			this.errorMessage = "success";
			return SUCCESS;
		}

		this.errorMessage = "The book can't be deleted because it has been borrowed or reserved";
		return INPUT;

	}

	public String bookManagement_Edit_Books() throws Exception {

		boolean borrowState = this.getModel().isBorrowState();
		boolean reservationState = this.getModel().isReservationState();

		try {
			if (borrowState == false && reservationState == false) {
				this.getService().updateBook(this.getModel());
				this.errorMessage = "success";
				return SUCCESS;
			}
			this.errorMessage = "The book can't be edited because it has been borrowed or reserved";
			return "failure";

		} catch (Exception ex) {
			this.addActionError(ex.getMessage());
			this.errorMessage = "failure";
			return INPUT;
		}

	}

	public String borrow_FindBook() {
		Book book = this.getService().confirmBookAuthority(bookId);
		if (book != null) {
			return SUCCESS;
		}
		this.errorMessage = "It's a wrong ID of book. or The book has been deleted";
		return INPUT;
	}

	// update book data after borrowing
	public String borrow_BookUpdate() {
		tempBook = this.getService().getBookById(bookId);
		if (tempBook.isBorrowState() == true) {
			this.errorMessage = "The book has been borrowed.";
			return INPUT;
		}
		if (tempBook.isReservationState() == true) {
			this.errorMessage = "The book has been reserved.";
			return INPUT;
		}
		tempBook.setReservationState(false);
		tempBook.setBorrowState(true);
		this.getService().mergeBook(tempBook);
		this.errorMessage = "success";
		return SUCCESS;
	}

	// update book data after returning
	public String return_BookUpdate() {
		bookId = this.getBookId();
//		System.out.println(bookId);

		try {
			tempBook = this.getService().getBookById(bookId);
			this.getService().updateReturnBook(tempBook);
		} catch (Exception e1) {
			this.errorMessage = "It is the wrong Id of book. or The record of this book may have been deleted.";
			return INPUT;
		}
		return SUCCESS;
	}

	public String viewBorrowInfo() {

//		System.out.println(records.listIterator().next().getBookId());
//		System.out.println("test");
//		Iterator<Record> listIterator = records.iterator();
//		
//		public BorrowInfo(long id, long bookId, long readerId, String bookName, int fineValue, String borrowDate,
//				String deadline, String returnDate, boolean payState) {

		for (int i = 0; i < records.size(); i++) {
			// 将已还罚金记录和未还罚金记录分组
			// payState为1表示已经提交罚金
			if (records.get(i).isPayState() == true) {
				payedFine.add(
						new BorrowInfo(records.get(i).getId(), records.get(i).getBookId(), records.get(i).getReaderId(),
								this.getService().getBookById(records.get(i).getBookId()).getTitle(),
								records.get(i).getFineValue(), records.get(i).getBorrowDate(),
								records.get(i).getDeadline(), records.get(i).getReturnDate(), true));
			}
			// 罚金不为零时，才显示罚金记录
			else if(records.get(i).getFineValue() != 0) {
				unPayedFine.add(
						new BorrowInfo(records.get(i).getId(), records.get(i).getBookId(), records.get(i).getReaderId(),
								this.getService().getBookById(records.get(i).getBookId()).getTitle(),
								records.get(i).getFineValue(), records.get(i).getBorrowDate(),
								records.get(i).getDeadline(), records.get(i).getReturnDate(), true));
			}
		}
		return SUCCESS;
	}

	public Book getTempBook() {
		return tempBook;
	}

	public void setTempBook(Book tempBook) {
		this.tempBook = tempBook;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
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

	public String getPageState() {
		return pageState;
	}

	public void setPageState(String pageState) {
		this.pageState = pageState;
	}

	public long getTempBookId() {
		return tempBookId;
	}

	public void setTempBookId(long tempBookId) {
		this.tempBookId = tempBookId;
	}

	/**
	 * @return the book_copy_number
	 */
	public long getBook_copy_number() {
		return book_copy_number;
	}

	/**
	 * @param book_copy_number the book_copy_number to set
	 */
	public void setBook_copy_number(long book_copy_number) {
		this.book_copy_number = book_copy_number;
	}

	/**
	 * @return the idList
	 */
	public List<BookCopy> getIdList() {
		return idList;
	}

	/**
	 * @param idList the idList to set
	 */
	public void setIdList(List<BookCopy> idList) {
		this.idList = idList;
	}

	public BookCopy getTempBookCopy() {
		return tempBookCopy;
	}

	public void setTempBookCopy(BookCopy tempBookCopy) {
		this.tempBookCopy = tempBookCopy;
	}

	/**
	 * @return the bookId
	 */
	public long getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the records
	 */
	public List<Record> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(List<Record> records) {
		this.records = records;
	}

	/**
	 * @return the payedFine
	 */
	public List<BorrowInfo> getPayedFine() {
		return payedFine;
	}

	/**
	 * @param payedFine the payedFine to set
	 */
	public void setPayedFine(List<BorrowInfo> payedFine) {
		this.payedFine = payedFine;
	}

	/**
	 * @return the unPayedFine
	 */
	public List<BorrowInfo> getUnPayedFine() {
		return unPayedFine;
	}

	/**
	 * @param unPayedFine the unPayedFine to set
	 */
	public void setUnPayedFine(List<BorrowInfo> unPayedFine) {
		this.unPayedFine = unPayedFine;
	}
	
}
