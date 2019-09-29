package service;

import entity.Book;

public class BookServiceImpl extends BaseService<Book> implements BookService{
	
	public void BookRegistration(Book book) {
		book.setReservationState(false);
		book.setBorrowState(false);
		this.getDao().save(book);
	}

}
