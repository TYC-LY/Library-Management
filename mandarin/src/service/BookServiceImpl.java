package service;

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
}
