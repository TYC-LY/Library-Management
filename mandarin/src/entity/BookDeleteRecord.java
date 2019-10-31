package entity;

public class BookDeleteRecord extends BaseEntity{
	
	private long bookId;
	private long librarianId;
	private String ISBN;
	
	public BookDeleteRecord() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	public BookDeleteRecord(long id, long bookId, long librarianId, String iSBN) {
		super(id);
		this.bookId = bookId;
		this.librarianId = librarianId;
		ISBN = iSBN;
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
	 * @return the librarianId
	 */
	public long getLibrarianId() {
		return librarianId;
	}

	/**
	 * @param librarianId the librarianId to set
	 */
	public void setLibrarianId(long librarianId) {
		this.librarianId = librarianId;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

}
