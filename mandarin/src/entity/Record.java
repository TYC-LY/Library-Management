package entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Record extends BaseEntity {

	private Date borrowDate;
	private Date deadline;
	private Date returnDate;
	private long readerId;
	private long bookId;
	private boolean payState;
	private int fineValue;
	private boolean reservationState;
	private boolean borrowState;
	
	public Record() {
		super(0);
	}
	
	public Record(long id, String borrowDate, Date deadline, String returnDate, long readerId, long bookId, boolean payState,
			int fineValue, boolean reservationState, boolean borrowState) {
		super(id);
		// TODO Auto-generated constructor stub
		this.deadline = deadline;
		this.readerId = readerId;
		this.bookId = bookId;
		this.payState = payState;
		this.fineValue = fineValue;
		this.reservationState = reservationState;
		this.borrowState = borrowState;
//		SimpleDateFormat bjsdf =   new SimpleDateFormat( "yyyy/MM/dd" ); 
//		bjsdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//		this.setBorrowDate(bjsdf.format(new Date()));
//		this.setDeadline(bjsdf.format(new Date()));
//		this.setReturnDate(bjsdf.format(new Date()));
		
		// 修改：
		this.setBorrowDate(new Date());
		this.setDeadline(new Date());
		this.setReturnDate(null);
		
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

	public boolean isPayState() {
		return payState;
	}

	public void setPayState(boolean payState) {
		this.payState = payState;
	}

	public int getFineValue() {
		return fineValue;
	}

	public void setFineValue(int fineValue) {
		this.fineValue = fineValue;
	}

	public boolean isReservationState() {
		return reservationState;
	}

	public void setReservationState(boolean reservationState) {
		this.reservationState = reservationState;
	}

	public boolean isBorrowState() {
		return borrowState;
	}

	public void setBorrowState(boolean borrowState) {
		this.borrowState = borrowState;
	}
}
