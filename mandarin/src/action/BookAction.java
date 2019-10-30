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

public class BookAction extends BaseAction<Book, BookService> {

	private static final long serialVersionUID = 1L;
	
	private List<List<Book>> bookTable = new ArrayList<List<Book>>();
	private List<Book> multiBookTable;
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
			if (hasIt(authorList, singleBook.get(i).getAuthor()) == false || hasIt(publisherList, singleBook.get(i).getPublisher()) == false) {
				singleBook.remove(singleBook.get(i--));
			}
		}
		return INPUT;
	}

	// 辅助方法。判断一个String的List中是否含有str
	private boolean hasIt(List<String> List, String str) {
		for (String string : List) {
			if (string.equals(str)) return true;
		}
		return false;
	}

	// 辅助方法。将search功能和screen功能中的查询部分分离出来
	public void searchHelper(String content, String option) {
		if (content == "" || option == "") return;
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
		case "isbn":
			setMultiBookTable(this.getService().getBooksByIsbn(content));
			break;
		}

		for(int i = 0; ; ) {
			if(i == multiBookTable.size()) {
				break;
			}
			List<Book> books = new ArrayList<Book>();
			while (i < multiBookTable.size() - 1 && multiBookTable.get(i).getIsbn().equals(multiBookTable.get(i + 1).getIsbn())) {
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
}
