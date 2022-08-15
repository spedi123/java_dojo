package com.spedi123.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.bookclub.models.Book;
import com.spedi123.bookclub.repositories.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	// ========== Create / Update ==========
	
	public Book save(Book book) {
		return bookRepo.save(book);
	}
	
	// ========== Read ==========
	
	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	public Book getOne(Long id) {
		return bookRepo.findById(id).orElse(null);
	}

	// ========== Delete ==========
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}