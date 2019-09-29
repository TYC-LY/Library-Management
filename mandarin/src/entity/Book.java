package entity;

public class Book extends BaseEntity{
	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private String description;
	private boolean reservationState;
	private boolean borrowState;
	private String location;
	private String price;
	private String categoryNo;
	
	public Book() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	public Book(long id, String iSBN, String title, String author, String publisher, String description,
			boolean reservationState, boolean borrowState, String location, String price, String categoryNo) {
		this();
		ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.description = description;
		this.reservationState = reservationState;
		this.borrowState = borrowState;
		this.location = location;
		this.price = price;
		this.categoryNo = categoryNo;
	}

	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the reservationState
	 */
	public boolean isReservationState() {
		return reservationState;
	}

	/**
	 * @param reservationState the reservationState to set
	 */
	public void setReservationState(boolean reservationState) {
		this.reservationState = reservationState;
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

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the categoryNo
	 */
	public String getCategoryNo() {
		return categoryNo;
	}

	/**
	 * @param categoryNo the categoryNo to set
	 */
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	
}
