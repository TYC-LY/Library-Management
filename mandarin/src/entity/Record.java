package entity;

public class Record extends BaseEntity {
	
	public Record() {
		super(0);
	}
	
	public Record(long id) {
		super(id);
	}

	private Reader reader;
	private Book book;
	private String borrowDate;
	private String returnDate;

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
