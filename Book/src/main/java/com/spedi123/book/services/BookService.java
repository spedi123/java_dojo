package com.spedi123.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spedi123.book.models.Book;
import com.spedi123.book.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	  // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // updates a book
    public Book updateBook(Long id, String title, String description, String language, Integer numOfPages) {
    	Book book = new Book();
    	book.setId(id);
    	book.setTitle(title);
    	book.setDescription(description);
    	book.setLanguage(language);
    	book.setNumberOfPages(numOfPages);
    	return bookRepo.save(book);
    }
    
    // deletes a book
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    }
}
