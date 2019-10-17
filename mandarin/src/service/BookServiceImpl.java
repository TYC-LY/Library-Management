package service;

import java.util.List;

import entity.Book;

public class BookServiceImpl extends BaseService<Book> implements BookService {

	@Override
	public Book getBookById(long id) {
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
	public List<Book> getBooksByIsbn(String searchContent) {
		return this.getDao().findBySubString("isbn", searchContent);
	}

}
