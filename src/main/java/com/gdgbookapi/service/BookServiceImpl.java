package com.gdgbookapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdgbookapi.entity.BookEntity;
import com.gdgbookapi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository repository;

	@Override
	public BookEntity create(BookEntity book) {
		return repository.save(book);
	}

	@Override
	public BookEntity update(BookEntity book) {
		return repository.save(book);
	}

	@Override
	public List<BookEntity> listAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Long bookId) {
		repository.deleteById(bookId);
	}

}
