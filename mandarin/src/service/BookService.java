package service;

import java.util.List;

import entity.Book;

public interface BookService {

	List<Book> getBooksByTitle(String searchContent);

	Book getBookById(long id);

}
