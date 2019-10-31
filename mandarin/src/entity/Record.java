package entity;

import java.util.Date;

public class Record extends BaseEntity {
	
	public Record() {
		super(0);
	}
	
	public Record(long id) {
		super(id);
	}

	private long readerId;
	private long bookId;
	private Date borrowDate;
	private Date deadline;
	private Date returnDate;
	private Boolean payState;
	private Integer fineValue;
	private Boolean reservationState;
	private Boolean borrowState;

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Integer getFineValue() {
		return fineValue;
	}

	public void setFineValue(Integer fineValue) {
		this.fineValue = fineValue;
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

	public long getReaderId() {
		return readerId;
	}

	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

}
