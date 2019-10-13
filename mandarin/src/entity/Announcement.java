package entity;

public class Announcement extends BaseEntity {
	private String author;
	private String title;
	private String content;
	
	public Announcement() {
		super(0);
	}
	
	public Announcement(long id, String author, String title, String content) {
		this();
		this.author = author;
		this.title = title;
		this.content = content;
	}

//	/**
//	 * @return the createDate
//	 */
//	public String getCreateDate() {
//		return createDate;
//	}
//
//	/**
//	 * @param createDate the createDate to set
//	 */
//	public void setCreateDate(String createDate) {
//		this.createDate = createDate;
//	}

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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


}
