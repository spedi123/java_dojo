package com.spedi123.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.spedi123.bookclub.models.Book;
import com.spedi123.bookclub.services.BookService;
import com.spedi123.bookclub.services.UserService;

@Controller
public class BookController {
	
	
	@Autowired
	private BookService bookServ;
	
	@Autowired 
	private UserService userServ;
	
	@GetMapping("/books")
	public String welcome(HttpSession session, Model model) {
		if(session.getAttribute("uuid") == null) {
			return "redirect:/logout";
		}
		
		Long uuid = (Long) session.getAttribute("uuid");
		model.addAttribute("user", userServ.getOne(uuid));
		model.addAttribute("books", bookServ.getAll());
		
		return "book_list.jsp";
	}
	
	@GetMapping("/books/new")
	public String addBook(Model model, HttpSession session) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		Long uuid = (Long) session.getAttribute("uuid");
		model.addAttribute("user", userServ.getOne(uuid));
		model.addAttribute("newBook", new Book());
    	return "book_add.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String bookDetail(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		Long uuid = (Long) session.getAttribute("uuid");
		model.addAttribute("user", userServ.getOne(uuid));
    	Book book = bookServ.getOne(id);
    	model.addAttribute("book", book);
    	return "book_detail.jsp";
	}
	
	@GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
    	Book book = bookServ.getOne(id);
    	model.addAttribute("book", book);
    	return "book_edit.jsp";
    }
	
	@GetMapping("/bookrent")
	public String rentbook(HttpSession session, Model model) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		Long uuid = (Long) session.getAttribute("uuid");
		model.addAttribute("user", userServ.getOne(uuid));
		
		List<Book> books = bookServ.unborrowedBooks(userServ.getOne(uuid));
		model.addAttribute("books", books);

		List<Book> myBooks = bookServ.borrowedBooks(userServ.getOne(uuid));
		model.addAttribute("myBooks", myBooks);
    	
		return "book_rent.jsp";
	}
	
	
    @PutMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book , BindingResult result, Model model, HttpSession session) {
    	if(result.hasErrors()) {
        	return "book_edit.jsp";
    	}
    	bookServ.save(book);
    	return "redirect:/books";
    }
	
	@PostMapping("/books/new")
	public String addBook(@Valid @ModelAttribute("newBook")Book book, BindingResult result, Model model,  HttpSession session) {
    	if(result.hasErrors()) {
    		model.addAttribute("allBooks", bookServ.getAll());
    		model.addAttribute("allUsers", userServ.getAll());
    		return "book_add.jsp";
    	}
    	bookServ.save(book);
    	return "redirect:/books";
    }
	
	@PutMapping("/bookrent/{bookID}")
	public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		Long uuid = (Long) session.getAttribute("uuid");
		
		bookServ.addBorrower(bookServ.getOne(bookID), userServ.getOne(uuid));
		 
		return "redirect:/bookrent";
	}
	
	@PutMapping("/bookrent/return/{bookID}")
	public String returnBook(@PathVariable("bookID") Long bookID, HttpSession session) {

		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		bookServ.removeBorrower(bookServ.getOne(bookID));
		 
		return "redirect:/bookrent";
	}
	
	 @DeleteMapping("/books/delete/{id}")
	    public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
	    	if(session.getAttribute("uuid") == null) {
	    		return "redirect:/";
	    	}
	    	bookServ.delete(id);
	    	return "redirect:/books";
	    }
	
	
}
