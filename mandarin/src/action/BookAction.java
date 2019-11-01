package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.Book;
import entity.Reader;
import entity.Record;
import service.BookService;
import service.RecordService;

//
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
import entity.Librarian;
import entity.Record;
import service.BookService;
import utils.BarCodeUtils;
import utils.BookXMLParser;
import utils.FontImage;

public class BookAction extends BaseAction<Book, BookService> {

	private static final long serialVersionUID = 1L;

	// reader
	private List<List<Book>> bookTable = new ArrayList<List<Book>>();
	private List<Book> multiBookTable = new ArrayList<Book>();
	private List<Book> singleBook = new ArrayList<Book>();
	private String searchContent;
	private String screenContent;
	private String screenOption;
	private List<String> multiAuthor;
	private List<String> multiPublisher;
	private List<String> publisherList = new ArrayList<String>();
	private List<String> authorList = new ArrayList<String>();
	private String option;
	private List<Record> currentTable;
	private List<Record> historyTable;
	private RecordService recordser;
	private long id;

	// admin-librarian
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

	private String location;
	
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
		private boolean borrowState;

		public BorrowInfo(long id, long bookId, long readerId, String bookName, int fineValue, Date borrowDate,
				Date deadline, Date returnDate, boolean payState, boolean borrowState) {
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
			this.borrowState = borrowState;
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

		/**
		 * @return the borrowState
		 */
		public boolean isBorrowState() {
			return borrowState;
		}

		/**
		 * @param borrowState the borrowState to set
		 */
		public void setBorrowState(boolean borrowState) {
			this.borrowState = borrowState;
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

	public String search() throws Exception {
		if (searchContent == "") {
			return INPUT;
		}

		searchHelper(searchContent, option);

		return INPUT;
	}

	public String screen() throws Exception {
		searchContent = screenContent;
		option = screenOption;
		searchHelper(searchContent, option);// 无论筛选与否都要根据上一次搜索的条件再搜索一次
		if (multiAuthor == null && multiPublisher == null) {
			// 不筛选和原来一样
			return INPUT;
		}
		if (multiAuthor == null) {
			authorList = new ArrayList<String>();
			publisherList = multiPublisher;
			for (int i = 0; i < singleBook.size(); i++) {
				if (hasIt(publisherList, singleBook.get(i).getPublisher()) == false) {
					singleBook.remove(singleBook.get(i--));
				}
			}
			for (Book book : singleBook) {
				if (hasIt(authorList, book.getAuthor()) == false) {
					authorList.add(book.getAuthor());
				}
			}
			return INPUT;
		}
		if (multiPublisher == null) {
			authorList = multiAuthor;
			publisherList = new ArrayList<String>();
			for (int i = 0; i < singleBook.size(); i++) {
				if (hasIt(authorList, singleBook.get(i).getAuthor()) == false) {
					singleBook.remove(singleBook.get(i--));
				}
			}
			for (Book book : singleBook) {
				if (hasIt(publisherList, book.getPublisher()) == false) {
					publisherList.add(book.getPublisher());
				}
			}
			return INPUT;
		}
		// 筛选则去除筛选条目之外的书本，并更改左侧筛选条目
		authorList = multiAuthor;
		publisherList = multiPublisher;
		for (int i = 0; i < singleBook.size(); i++) {
			if (hasIt(authorList, singleBook.get(i).getAuthor()) == false
					|| hasIt(publisherList, singleBook.get(i).getPublisher()) == false) {
				singleBook.remove(singleBook.get(i--));
			}
		}
		return INPUT;
	}

	// 辅助方法。判断一个String的List中是否含有str
	private boolean hasIt(List<String> List, String str) {
		for (String string : List) {
			if (string.equals(str))
				return true;
		}
		return false;
	}

	// 辅助方法。将search功能和screen功能中的查询部分分离出来
	public void searchHelper(String content, String option) {
		if (content == "" || option == "")
			return;
		switch (option) {
		case "title":
			setMultiBookTable(this.getService().getBooksByTitle(content));
			break;
		case "author":
			setMultiBookTable(this.getService().getBooksByAuthor(content));
			break;
		case "publisher":
			setMultiBookTable(this.getService().getBooksByPublisher(content));
			break;
		case "ISBN":
			setMultiBookTable(this.getService().getBooksByISBN(content));
			break;
		}

		for (int i = 0;;) {
			if (i == multiBookTable.size()) {
				break;
			}
			List<Book> books = new ArrayList<Book>();
			while (i < multiBookTable.size() - 1
					&& multiBookTable.get(i).getISBN().equals(multiBookTable.get(i + 1).getISBN())) {
				books.add(multiBookTable.get(i));
				i++;
			}
			books.add(multiBookTable.get(i));
			singleBook.add(multiBookTable.get(i));
			i++;
			bookTable.add(books);
		}

		for (Book book : singleBook) {
			if (hasIt(authorList, book.getAuthor()) == false) {
				authorList.add(book.getAuthor());
			}
			if (hasIt(publisherList, book.getPublisher()) == false) {
				publisherList.add(book.getPublisher());
			}
		}
	}

	// TODO: 预约 三本书 判断
	public String reserve() throws Exception {
		int state = 0;// ajax过程中返回状态
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader reader = (Reader) session.get("reader");
		if (reader == null) {
			System.out.println("no reader");
			state = -1;
			return "login";
		}

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);

		Date borrowDate = date;
		Date deadline = c.getTime();
		System.out.println(deadline);
		// Book reBook = this.bookser.getBookById(id); //the id of book you want to
		// reserve

		List<Record> recordTable = recordser.getRecordByReader(reader);
		int sum = 0;
		for (Record s : recordTable)
			if (s.getBorrowState() || s.getReservationState()) {
				sum++;
			}
		System.out.println(sum);
		if (sum >= 3) {
			setErrorMessage("Fail to reserve, you have reserved or borrowed 3 books!");
			state = 2;
			ServletActionContext.getResponse().getWriter().print(state);
			return null;
		}

		Book book = this.getService().getBookById_reader(this.getModel().getId());
		if (book.getReservationState().equals(false) & sum < 3) {
			System.out.println("aaaaaaa");
			book.setReservationState(true);
			this.getService().mergeBook_reader(book);

			Record record = new Record();
			record.setBorrowDate(borrowDate);
			record.setDeadline(deadline);
			record.setReaderId(reader.getId());
			record.setBookId(book.getId());
			record.setPayState(false);
			record.setFineValue(0);
			record.setReservationState(true);
			record.setBorrowState(false);

			this.getRecordser().reserve(record);
			state = 1;
		}

		setErrorMessage("Reservation Complete!!!");
		ServletActionContext.getResponse().getWriter().print(state);
		return null;
	}

//	public String getBookByCurrentRecord() throws Exception {
//		bookTable = new ArrayList<Book>();
//		for (Record record : currentTable) {
//			bookTable.add(this.getService().getBookById(record.getBook().getId()));
//		}
//		return INPUT;
//	}
//	
//	public String getBookByHistoryRecord() throws Exception {
//		bookTable = new ArrayList<Book>();
//		for (Record record : historyTable) {
//			bookTable.add(this.getService().getBookById(record.getBook().getId()));
//		}
//		return INPUT;
//	}

	// bookTable

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
		if (tempBook.getCategoryNo() == null) {
			tempBook.setCategoryNo("null");
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
		setLocation("area:" + location_area + " floor:" + location_floor + " stack:" + location_stack);
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
//			System.out.println(tempBook.getId());

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
			return INPUT;
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
			return INPUT;
		}

		this.errorMessage = "success";
		return SUCCESS;
	}

	public String bookManagement_Add_Books_Copy() throws Exception {

		this.book_copy_number = this.getBook_copy_number();
		this.idList = new ArrayList<BookCopy>();

		if (book_copy_number == 0) {
			this.errorMessage = "Your need to type in the number.";
			return INPUT;
		}

		// 循环加入书本
//		for (long i = 0; i <= book_copy_number; i++) {
		// <=是錯誤的
		for (long i = 0; i < book_copy_number; i++) {

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
			setLocation(bookLocation);
			// 生成barcode
			try {
				BufferedImage image = BarCodeUtils.insertWords(BarCodeUtils.getBarCode(idString), idString);
				ImageIO.write(image, "jpg", new File("D://barcode//" + idString + ".jpg"));
			} catch (IOException ioex) {
				this.addActionError(ioex.getMessage());
				this.errorMessage = "failure to create the barcode";
				return INPUT;
			}

			// 生成the image of the bookLoaction
			try {
				FontImage.createImage(bookLocation, new Font("Arial", Font.BOLD, 72),
						new File("d:/booklocation/" + idString + ".png"), bookLocation.length() * 40, 200);
			} catch (IOException ioex) {
				this.addActionError(ioex.getMessage());
				this.errorMessage = "failure to create the image of the book location";
				return INPUT;
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

		boolean borrowState = this.getModel().getBorrowState();
		boolean reservationState = this.getModel().getReservationState();
//		
//		System.out.println(borrowState);
//		System.out.println(reservationState);
//		System.out.println(this.getModel().getTitle());
//		System.out.println(this.getModel().getISBN());
//		

		Map<String, Object> session = ActionContext.getContext().getSession();
		Librarian librarian = (Librarian) session.get("librarian");
		if (librarian == null) {
			this.errorMessage = "You need to login the librarian account";
			return INPUT;
		}

		if (borrowState == false && reservationState == false) {
			this.getService().deleteBookById(this.getTempBookId());
			this.errorMessage = "success";
			return SUCCESS;
		}

		this.errorMessage = "The book can't be deleted because it has been borrowed or reserved";
		return INPUT;

	}

	public String bookManagement_Edit_Books() throws Exception {

		boolean borrowState = this.getModel().getBorrowState();
		boolean reservationState = this.getModel().getReservationState();

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
		tempBook = this.getService().getBookById_reader(bookId);
		if (tempBook.getBorrowState() == true) {
			this.errorMessage = "The book has been borrowed.";
			return INPUT;
		}
		if (tempBook.getReservationState() == true) {
			this.errorMessage = "The book has been reserved.";
			return INPUT;
		}
		tempBook.setReservationState(false);
		tempBook.setBorrowState(true);
		this.getService().mergeBook_reader(tempBook);
		this.errorMessage = "success";
		return SUCCESS;
	}

	// update book data after returning
	public String return_BookUpdate() {
		bookId = this.getBookId();
//		System.out.println(bookId);

		try {
			tempBook = this.getService().getBookById_reader(bookId);
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

			// 此处为添加:未交罚金
			if (records.get(i).getPayState() != true && records.get(i).getFineValue() != 0) {
				unPayedFine.add(new BorrowInfo(records.get(i).getId(), records.get(i).getBookId(),
						records.get(i).getReaderId(),
						this.getService().getBookById_reader(records.get(i).getBookId()).getTitle(),
						records.get(i).getFineValue(), records.get(i).getBorrowDate(), records.get(i).getDeadline(),
						records.get(i).getReturnDate(), false, records.get(i).getBorrowState()));
			}
			// 犯错误:罚金不为零时，才显示罚金记录
			// else if(records.get(i).getFineValue() != 0) {

			// 此处为添加:其他记录,包括:已交罚金或已还书籍
			else {
				payedFine.add(new BorrowInfo(records.get(i).getId(), records.get(i).getBookId(),
						records.get(i).getReaderId(),
						this.getService().getBookById_reader(records.get(i).getBookId()).getTitle(),
						records.get(i).getFineValue(), records.get(i).getBorrowDate(), records.get(i).getDeadline(),
						records.get(i).getReturnDate(), true, records.get(i).getBorrowState()));
			}
		}
		return SUCCESS;
	}

	public String revert_Lend_Book_Update() {
		this.bookId = this.getBookId();
		try {
			tempBook = this.getService().getBookById_reader(bookId);
			tempBook.setBorrowState(false);
			this.getService().mergeBook_reader(tempBook);
		} catch (Exception e1) {
			return INPUT;
		}
		return SUCCESS;
	}

	public List<List<Book>> getBookTable() {
		return bookTable;
	}

	public void setBookTable(List<List<Book>> bookTable) {
		this.bookTable = bookTable;
	}

	// searchContent
	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public List<Record> getCurrentTable() {
		return currentTable;
	}

	public void setCurrentTable(List<Record> currentTable) {
		this.currentTable = currentTable;
	}

	public List<Record> getHistoryTable() {
		return historyTable;
	}

	public void setHistoryTable(List<Record> historyTable) {
		this.historyTable = historyTable;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public RecordService getRecordser() {
		return recordser;
	}

	public void setRecordser(RecordService recordser) {
		this.recordser = recordser;
	}

	public List<Book> getMultiBookTable() {
		return multiBookTable;
	}

	public void setMultiBookTable(List<Book> multiBookTable) {
		this.multiBookTable = multiBookTable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Book> getSingleBook() {
		return singleBook;
	}

	public void setSingleBook(List<Book> singleBook) {
		this.singleBook = singleBook;
	}

	public List<String> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<String> publisherList) {
		this.publisherList = publisherList;
	}

	public List<String> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<String> authorList) {
		this.authorList = authorList;
	}

	public String getScreenContent() {
		return screenContent;
	}

	public void setScreenContent(String screenContent) {
		this.screenContent = screenContent;
	}

	public String getScreenOption() {
		return screenOption;
	}

	public void setScreenOption(String screenOption) {
		this.screenOption = screenOption;
	}

	public List<String> getMultiAuthor() {
		return multiAuthor;
	}

	public void setMultiAuthor(List<String> multiAuthor) {
		this.multiAuthor = multiAuthor;
	}

	public List<String> getMultiPublisher() {
		return multiPublisher;
	}

	public void setMultiPublisher(List<String> multiPublisher) {
		this.multiPublisher = multiPublisher;
	}

	public Book getTempBook() {
		return tempBook;
	}

	public void setTempBook(Book tempBook) {
		this.tempBook = tempBook;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
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

	public long getBook_copy_number() {
		return book_copy_number;
	}

	public void setBook_copy_number(long book_copy_number) {
		this.book_copy_number = book_copy_number;
	}

	public List<BookCopy> getIdList() {
		return idList;
	}

	public void setIdList(List<BookCopy> idList) {
		this.idList = idList;
	}

	public BookCopy getTempBookCopy() {
		return tempBookCopy;
	}

	public void setTempBookCopy(BookCopy tempBookCopy) {
		this.tempBookCopy = tempBookCopy;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public List<BorrowInfo> getPayedFine() {
		return payedFine;
	}

	public void setPayedFine(List<BorrowInfo> payedFine) {
		this.payedFine = payedFine;
	}

	public List<BorrowInfo> getUnPayedFine() {
		return unPayedFine;
	}

	public void setUnPayedFine(List<BorrowInfo> unPayedFine) {
		this.unPayedFine = unPayedFine;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
