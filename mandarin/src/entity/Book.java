package entity;

public class Book extends BaseEntity{
	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private String description;
	private boolean reservationState;
	private boolean borrowState;
	private String location_floor;
	private String location_stack;
	private String location_area;
	private String price;
	private String categoryNo;
	private String imagePath;
	
	public Book() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	public Book(long id, String iSBN, String title, String author, String publisher, String description,
			boolean reservationState, boolean borrowState, String location_floor, String location_stack,
			String location_area, String price, String categoryNo, String imagePath) {
		super(id);
		ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.description = description;
		this.reservationState = reservationState;
		this.borrowState = borrowState;
		this.location_floor = location_floor;
		this.location_stack = location_stack;
		this.location_area = location_area;
		this.price = price;
		this.categoryNo = categoryNo;
		this.imagePath = imagePath;
	}

	public String getLocation_floor() {
		return location_floor;
	}



	public void setLocation_floor(String location_floor) {
		this.location_floor = location_floor;
	}



	public String getLocation_stack() {
		return location_stack;
	}



	public void setLocation_stack(String location_stack) {
		this.location_stack = location_stack;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getLocation_area() {
		return location_area;
	}

	public void setLocation_area(String location_area) {
		this.location_area = location_area;
	}
	
	
}
