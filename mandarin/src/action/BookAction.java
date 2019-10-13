package action;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.opensymphony.xwork2.ActionContext;

import entity.Book;
import service.BookService;
import utils.BarCodeUtils;
import utils.BookXMLParser;
import utils.FontImage;

public class BookAction extends BaseAction<Book, BookService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Book tempBook;
	private String url = "http://api.douban.com/book/subject/isbn/";
	private String apikey = "0b2bdeda43b5688921839c8ecb20399b";

	public String bookManagement_Find_Book_Detail() throws Exception {

		String ISBN = this.getModel().getISBN();
		String requestUrl = this.url + ISBN + "?apikey=" + this.apikey;

		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(requestUrl);
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		InputStream is = entity.getContent();
		this.tempBook = new BookXMLParser(is).getBook();
		
		if(tempBook.getTitle() == null) {
			tempBook.setTitle("null");
		}
		if(tempBook.getAuthor() == null) {
			tempBook.setAuthor("null");
		}
		if(tempBook.getPrice() == null) {
			tempBook.setPrice("null");
		}
		if(tempBook.getPublisher() == null) {
			tempBook.setPublisher("null");
		}
		if(tempBook.getISBN() == null) {
			tempBook.setISBN("null");
		}
		if(tempBook.getDescription() == null) {
			tempBook.setDescription("There is no description about the book.");
		}

		return SUCCESS;
	}

	public String bookManagement_Add_Books() throws Exception {
		String ISBN = this.getModel().getISBN();
		String title = this.getModel().getTitle();
		String author = this.getModel().getAuthor();
		String publisher = this.getModel().getPublisher();
		String description = this.getModel().getDescription();
		String location = this.getModel().getLocation();
		String price = this.getModel().getPrice();
		String categoryNo = this.getModel().getCategoryNo();
		if (ISBN.isEmpty()) {
			this.errorMessage = "ISBN can not be empty";
			return INPUT;
		} else if (title.isEmpty()) {
			this.errorMessage = "title can not be empty";
			return INPUT;
		} else if (author.isEmpty()) {
			this.errorMessage = "author can not be empty";
			return INPUT;
		} else if (publisher.isEmpty()) {
			this.errorMessage = "publisher can not be empty";
			return INPUT;
		} else if (description.isEmpty()) {
			this.errorMessage = "description can not be empty";
			return INPUT;
		} else if (location.isEmpty()) {
			this.errorMessage = "location can not be empty";
			return INPUT;
		} else if (price.isEmpty()) {
			this.errorMessage = "price can not be empty";
			return INPUT;
		} else if (categoryNo.isEmpty()) {
			this.errorMessage = "categoryNo can not be empty";
			return INPUT;
		}

		// add book
		try {
			this.getService().addBook(this.getModel());
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("book", this.getModel());
			tempBook = this.getModel();
			
		} catch (Exception ex) {
			this.addActionError(ex.getMessage());
			this.errorMessage = "failure";
			return INPUT;
		}

		long id = this.getModel().getId();
		String idString = String.valueOf(id);
		// 生成barcode
		try {
			BufferedImage image = BarCodeUtils.insertWords(BarCodeUtils.getBarCode(idString), idString);
			ImageIO.write(image, "jpg", new File("D://barcode//" + idString + ".jpg"));
		} catch (IOException ioex) {
			this.addActionError(ioex.getMessage());
			this.errorMessage = "failure to create the barcode";
		}

		String bookLocation = this.getModel().getLocation();
		// 生成the image of the bookLoaction
		try {
			FontImage.createImage(bookLocation, new Font("Arial", Font.BOLD, 72),
					new File("d:/booklocation/" + idString + ".png"), bookLocation.length() * 40, 200);
		} catch (IOException ioex) {
			this.addActionError(ioex.getMessage());
			this.errorMessage = "failure to create the image of the book location";
		}

		this.errorMessage = "success";
		return SUCCESS;
	}

	public String bookManagement_Add_Books_Copy() throws Exception {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		tempBook = (Book) session.get("book");
		ActionContext.getContext().getSession().clear();
		tempBook.setId(tempBook.getId()+1);
		// borrowState reservationState在addBook(service)中设置
//		this.getModel().setAuthor(tempBook.getAuthor());
//		this.getModel().setCategoryNo(tempBook.getCategoryNo());
//		this.getModel().setDescription(tempBook.getDescription());
//		this.getModel().setISBN(tempBook.getISBN());
//		this.getModel().setLocation(tempBook.getLocation());
//		this.getModel().setPrice(tempBook.getPrice());
//		this.getModel().setPublisher(tempBook.getPublisher());
//		this.getModel().setTitle(tempBook.getTitle());

		// add book
		try {
			this.getService().addBookCopy(tempBook);
			
			Map<String, Object> session2 = ActionContext.getContext().getSession();
			session2.put("book", tempBook);
			//
//			tempBook = this.getModel();
		} catch (Exception ex) {
			this.addActionError(ex.getMessage());
			this.errorMessage = "failure";
			return INPUT;
		}

		long id = tempBook.getId();
		
		// 点击add copy之后，新增的书的id变为原书的id+1
		// 系统默认id为0
		// 设置id的值才能保证前端页面的src能找到对应的图片
		this.getModel().setId(id);
		
		// 根据idString和bookLocation生成对应的条形码和图片
		String idString = String.valueOf(id);
		String bookLocation = tempBook.getLocation();
		
		// 生成barcode
		try {
			BufferedImage image = BarCodeUtils.insertWords(BarCodeUtils.getBarCode(idString), idString);
			ImageIO.write(image, "jpg", new File("D://barcode//" + idString + ".jpg"));
		} catch (IOException ioex) {
			this.addActionError(ioex.getMessage());
			this.errorMessage = "failure to create the barcode";
		}
		
		// 生成the image of the bookLoaction
		try {
			FontImage.createImage(bookLocation, new Font("Arial", Font.BOLD, 72),
					new File("d:/booklocation/" + idString + ".png"), bookLocation.length() * 40, 200);
		} catch (IOException ioex) {
			this.addActionError(ioex.getMessage());
			this.errorMessage = "failure to create the image of the book location";
		}

		this.errorMessage = "succeed to copy the book";
		return SUCCESS;

	}

	public Book getTempBook() {
		return tempBook;
	}

	public void setTempBook(Book tempBook) {
		this.tempBook = tempBook;
	}

}
