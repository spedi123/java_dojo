package com.spedi123.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.bookclub.models.Book;
import com.spedi123.bookclub.models.User;
import com.spedi123.bookclub.repositories.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	// ========== Create / Update ==========
	
	public Book save(Book book) {
		return bookRepo.save(book);
	}
	
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepo.save(book);
	}
	
	// ========== Read ==========
	
	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	public Book getOne(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	public List<Book> unborrowedBooks(User user){
		return bookRepo.findByBorrowerIdIsOrUserIdIs(null, user.getId());
	}
	
	public List<Book> borrowedBooks(User user){
		return bookRepo.findByBorrowerIdIs(user.getId());
	}

	// ========== Delete ==========
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
	
	public void removeBorrower(Book book) {
		book.setBorrower(null);
		bookRepo.save(book);
	}
	


}