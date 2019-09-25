package service;

import java.util.List;

import entity.Book;

public class BookServiceImpl extends BaseService<Book> implements BookService {

	@Override
	public List<Book> getBooksByTitle(String searchContent) {
		return this.getDao().findBySubString("title", searchContent);
	}
	
	@Override
	public Book getBookById(long id) {
		return this.getDao().get(id);
	}

}
