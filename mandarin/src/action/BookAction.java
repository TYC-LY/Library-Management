package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.Book;
import entity.Reader;
import entity.Record;
import service.BookService;
import service.RecordService;

public class BookAction extends BaseAction<Book, BookService> {

	private static final long serialVersionUID = 1L;
	
	private List<List<Book>> bookTable = new ArrayList<List<Book>>();
	private List<Book> multiBookTable;
	private List<Book> singleBook = new ArrayList<Book>();
	private String searchContent;
	private String option;
	private List<Record> currentTable;
	private List<Record> historyTable;
	private RecordService recordser;
	private long id;

	public String searchTitle() throws Exception {
		if (searchContent == "") {
			return INPUT;
		}
		switch (this.getOption()) {
		case "title":
			setMultiBookTable(this.getService().getBooksByTitle(searchContent));
			break;
		case "author":
			setMultiBookTable(this.getService().getBooksByAuthor(searchContent));
			break;
		case "publisher":
			setMultiBookTable(this.getService().getBooksByPublisher(searchContent));
			break;
		case "isbn":
			setMultiBookTable(this.getService().getBooksByIsbn(searchContent));
			break;
		}

		for(int i = 0; ; ) {
			System.out.println(i);
			if(i == multiBookTable.size()) {
				System.out.println("我要跳了！");
				break;
			}
			List<Book> books = new ArrayList<Book>();
			while (i < multiBookTable.size() - 1 && multiBookTable.get(i).getIsbn().equals(multiBookTable.get(i + 1).getIsbn())) {
				System.out.println(i);
				books.add(multiBookTable.get(i));
				i++;
			}
			books.add(multiBookTable.get(i));
			singleBook.add(multiBookTable.get(i));
			i++;
			bookTable.add(books);
		}
		
		return INPUT;
	}

	//TODO: 预约 三本书 判断
	public String reserve() throws Exception {
		int state = 0;//ajax过程中返回状态
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

		String borrowDate = format.format(date);
		String deadline = format.format(c.getTime());
		System.out.println(deadline);
		// Book reBook = this.bookser.getBookById(id); //the id of book you want to
		// reserve

		Book book = this.getService().getBookById(this.getModel().getId());
		if (book.getReservationState().equals(false)) {
			System.out.println("aaaaaaa");
			book.setReservationState(true);
			this.getService().mergeBook(book);
			
			Record record = new Record();
			record.setBorrowDate(borrowDate);
			record.setDeadline(deadline);
			record.setReader(reader);
			record.setBook(book);
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
}
