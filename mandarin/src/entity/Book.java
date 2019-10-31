package entity;

public class Book extends BaseEntity {
	
	public Book() {
		super(0);
	}

	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private String description;
	private Boolean reservationState;
	private Boolean borrowState;
	private String location_floor;
	private String location_stack;
	private String location_area;
	private String price;
	private String categoryNo;
	private String imagePath;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

	public String getLocation_area() {
		return location_area;
	}

	public void setLocation_area(String location_area) {
		this.location_area = location_area;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

}
