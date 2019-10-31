package service;

import java.util.List;

import entity.Book;
import entity.Record;

public class BookServiceImpl extends BaseService<Book> implements BookService {

	@Override
	public Book getBookById_reader(long id) {
		return this.getDao().get(id);
	}
	
	@Override
	public List<Book> getBooksByTitle(String searchContent) {
		return this.getDao().findBySubString("title", searchContent);
	}

	@Override
	public List<Book> getBooksByAuthor(String searchContent) {
		return this.getDao().findBySubString("author", searchContent);
	}

	@Override
	public List<Book> getBooksByPublisher(String searchContent) {
		return this.getDao().findBySubString("publisher", searchContent);
	}

	@Override
	public List<Book> getBooksByISBN(String searchContent) {
		return this.getDao().findBySubString("ISBN", searchContent);
	}

	@Override
	public void mergeBook_reader(Book book) {
		this.getDao().save(book);
	}

	
	
	
	
	
	public void addBook(Book book) {
		book.setReservationState(false);
		book.setBorrowState(false);
		this.getDao().save(book);
	}

	public void addBookCopy(Book book) {
		book.setReservationState(false);
		book.setBorrowState(false);
		this.getDao().saveCopy(book);
	}

	@Override
	public List<Book> searchBook(String condition, String content) {
		// TODO Auto-generated method stub
		return this.getDao().findBy(condition, content);
	}
	
	public void deleteBookById(long id) {
		this.getDao().delete(id);
	}
	
	public void updateBook(Book book) {
		book.setReservationState(false);
		book.setBorrowState(false);
		this.getDao().merge(book);
	}

	@Override
	public Book confirmBookAuthority(long bookId) {
		// TODO Auto-generated method stub
		Book book = this.getDao().getSingle("id", bookId);
		if (book != null) {
			  return book;
		}
		return null;
	}

	@Override
	public void mergeBook(Book tempBook) {
		// TODO Auto-generated method stub
		this.getDao().merge(tempBook);
	}

	@Override
	public Book getBookById(long bookId) {
		// TODO Auto-generated method stub
		Book book = this.getDao().getSingle("id", bookId);
		return book;
	}

	@Override
	public void updateReturnBook(Book tempBook) {
		// TODO Auto-generated method stub
		tempBook.setBorrowState(false);
		this.getDao().merge(tempBook);
	}
	
}
