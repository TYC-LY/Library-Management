package service;

import java.util.List;

import entity.Book;

public class BookServiceImpl extends BaseService<Book> implements BookService{
	
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
		book.setImagePath("6657");
		this.getDao().merge(book);
	}
}
