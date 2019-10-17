package service;

import java.util.List;

import entity.Book;

public interface BookService {

	Book getBookById(long id);
	
	List<Book> getBooksByTitle(String searchContent);

	List<Book> getBooksByAuthor(String searchContent);

	List<Book> getBooksByPublisher(String searchContent);

	List<Book> getBooksByIsbn(String searchContent);

}
