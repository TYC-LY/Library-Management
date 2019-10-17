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
	private String deadline;
	private String returnDate;
	private Boolean payState;
	private Integer fineValue;
	private Boolean reservationState;
	private Boolean borrowState;

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

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Integer getFineValue() {
		return fineValue;
	}

	public void setFineValue(Integer fineValue) {
		this.fineValue = fineValue;
	}

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

	public Boolean getPayState() {
		return payState;
	}

	public void setPayState(Boolean payState) {
		this.payState = payState;
	}

	public Boolean getReservationState() {
		return reservationState;
	}

	public void setReservationState(Boolean reservationState) {
		this.reservationState = reservationState;
	}

	public Boolean getBorrowState() {
		return borrowState;
	}

	public void setBorrowState(Boolean borrowState) {
		this.borrowState = borrowState;
	}

}
