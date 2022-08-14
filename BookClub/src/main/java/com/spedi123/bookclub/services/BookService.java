package com.spedi123.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.bookclub.models.Book;
import com.spedi123.bookclub.repositories.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	// ========== Create / Update ==========

	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	// ========== Read ==========

	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	public Book getOne(Long id) {
		Optional<Book> book =  bookRepo.findById(id);
		if (!book.isPresent()) {
			return null;
		}
		return book.get();
	}
	
	// ========== Delete ==========
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
