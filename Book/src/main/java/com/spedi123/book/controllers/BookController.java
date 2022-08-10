package com.spedi123.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spedi123.book.models.Book;
import com.spedi123.book.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@GetMapping("/books/{bookId}")
	public String show(
		Model model,
		@PathVariable("bookId") Long bookId
		) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book")Book book) {
		return "new.jsp";
	}
	
	@PostMapping("/books")
	public String create(@ModelAttribute("book")Book book, BindingResult result)
	{
		if(result.hasErrors()) {
			return "new.jsp";
		}
		
	    bookService.createBook(book);
	    
	    return "redirect:/dashboard";
	}
}















