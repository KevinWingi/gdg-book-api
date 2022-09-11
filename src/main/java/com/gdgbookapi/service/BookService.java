package com.gdgbookapi.service;

import com.gdgbookapi.entity.BookEntity;

public interface BookService {
	
	public BookEntity create(BookEntity book);
	public BookEntity update(BookEntity book);
	public java.util.List<BookEntity> listAll();
	public void delete(Long bookId);
	
}
