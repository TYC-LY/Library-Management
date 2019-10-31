package service;

import java.util.List;

import entity.Book;
import entity.Record;

public interface BookService {
	
	List<Book> getBooksByTitle(String searchContent);

	List<Book> getBooksByAuthor(String searchContent);

	List<Book> getBooksByPublisher(String searchContent);

	List<Book> getBooksByISBN(String searchContent);

	Book getBookById_reader(long id);

	void mergeBook_reader(Book book);

	public void addBook(Book book);

	public void addBookCopy(Book book);

	public List<Book> searchBook(String condition, String content);

	public void deleteBookById(long id);
	
	public void updateBook(Book book);

	public Book confirmBookAuthority(long bookId);

	public void mergeBook(Book tempBook);

	public Book getBookById(long bookId);

	public void updateReturnBook(Book tempBook);
}
