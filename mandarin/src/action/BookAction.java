package action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import entity.Book;
import entity.Record;
import service.BookService;

public class BookAction extends BaseAction<Book, BookService> {

	private static final long serialVersionUID = 1L;

	private List<Book> bookTable;
	private String searchContent;
	private String option;
	private List<Record> currentTable;
	private List<Record> historyTable;

	public String searchTitle() throws Exception {
		if (searchContent == "") {
			return INPUT;
		}
		switch (this.getOption()) {
			case "title":
				setBookTable(this.getService().getBooksByTitle(searchContent));
				break;
			case "author":
				setBookTable(this.getService().getBooksByAuthor(searchContent));
				break;
			case "publisher":
				setBookTable(this.getService().getBooksByPublisher(searchContent));
				break; 
			case "isbn":
				setBookTable(this.getService().getBooksByIsbn(searchContent));
				break; 
		}

		return INPUT;
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
	public List<Book> getBookTable() {
		return bookTable;
	}

	public void setBookTable(List<Book> bookTable) {
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
}
