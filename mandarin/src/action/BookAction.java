package action;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import entity.Book;
import service.BookService;
import utils.BookXMLParser;


public class BookAction extends BaseAction<Book, BookService>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Book tempBook;
	private String url="http://api.douban.com/book/subject/isbn/";
	private String apikey = "0b2bdeda43b5688921839c8ecb20399b";
	
	public String bookManagement_Find_Book_Detail() throws Exception{
		
		String ISBN = this.getModel().getISBN();
		String requestUrl = this.url + ISBN + "?apikey=" + this.apikey;
		
		DefaultHttpClient client = new DefaultHttpClient();
	    HttpGet get = new HttpGet(requestUrl);
	    HttpResponse response = client.execute(get);
	        HttpEntity entity = response.getEntity();
	        InputStream is = entity.getContent();
	        this.tempBook= new BookXMLParser(is).getBook();
	    
	    return SUCCESS;
	}

	public String bookManagement_Add_Books() throws Exception{
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

	public Book getTempBook() {
		return tempBook;
	}

	public void setTempBook(Book tempBook) {
		this.tempBook = tempBook;
	}

}
