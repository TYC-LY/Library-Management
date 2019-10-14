package entity;

public class Book extends BaseEntity {
	
	public Book() {
		super(0);
	}

	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String description;
	private Boolean reservationState;
	private Boolean borrowState;
	private String location;
	private String price;
	private String imgpath;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
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
