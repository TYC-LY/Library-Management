package action;

import entity.Book;
import service.BookService;

public class BookAction extends BaseAction<Book, BookService>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String BookRegistration() throws Exception{
		String ISBN = this.getModel().getISBN();
		String title = this.getModel().getTitle();
		String author = this.getModel().getAuthor();
		String publisher = this.getModel().getPublisher();
		String description = this.getModel().getDescription();
		String location = this.getModel().getLocation();
		String price = this.getModel().getPrice();
		String categoryNo = this.getModel().getCategoryNo();
		if(ISBN.isEmpty()) {
			this.errorMessage="ISBN can not be empty";
			return INPUT;
		}
		else if(title.isEmpty()) {
			this.errorMessage="title can not be empty";
			return INPUT;
		}
		else if(author.isEmpty()) {
			this.errorMessage="author can not be empty";
			return INPUT;
		}
		else if(publisher.isEmpty()) {
			this.errorMessage="publisher can not be empty";
			return INPUT;
		}
		else if(description.isEmpty()) {
			this.errorMessage="description can not be empty";
			return INPUT;
		}
		else if(location.isEmpty()) {
			this.errorMessage="location can not be empty";
			return INPUT;
		}
		else if(price.isEmpty()) {
			this.errorMessage="price can not be empty";
			return INPUT;
		}
		else if(categoryNo.isEmpty()) {
			this.errorMessage="categoryNo can not be empty";
			return INPUT;
		}
		
		try {
			this.getService().BookRegistration(this.getModel());
		}
		catch(Exception ex){
			this.addActionError(ex.getMessage());
			this.errorMessage="failure";
			return INPUT;
		}
		this.errorMessage="success";
		return SUCCESS;
	}

}
