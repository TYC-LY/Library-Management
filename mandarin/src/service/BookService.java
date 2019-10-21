package service;

import java.util.List;

import entity.Book;

public interface BookService {
	
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
