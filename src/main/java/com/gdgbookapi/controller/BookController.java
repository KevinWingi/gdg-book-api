package com.gdgbookapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdgbookapi.dto.BookDTO;
import com.gdgbookapi.entity.BookEntity;
import com.gdgbookapi.service.BookService;

@RestController
@RequestMapping(value = "books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<BookEntity> create(@RequestBody @Valid BookDTO dto) {
		BookEntity book = mapper.map(dto, BookEntity.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(book));
	}
	
	@PutMapping
	public ResponseEntity<BookEntity> update(@RequestBody @Valid BookEntity dto) {
		BookEntity book = mapper.map(dto, BookEntity.class);
		return ResponseEntity.ok(service.update(book));

	}
	
	@GetMapping
	public ResponseEntity<List<BookEntity>> listAll() {
		return ResponseEntity.ok(service.listAll());
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long bookId) {
		service.delete(bookId);
		return ResponseEntity.ok().build();
	}
	
}
