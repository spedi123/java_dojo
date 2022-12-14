package com.spedi123.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spedi123.bookclub.models.LoginUser;
import com.spedi123.bookclub.models.User;
import com.spedi123.bookclub.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
//	
//	@Autowired
//	private BookService bookServ;
	
	// ========== Display ==========

//	@GetMapping("/")
//	public String index(@ModelAttribute("newUser")User newUser, @ModelAttribute("newLogin")LoginUser newLogin) {
//		return "index.jsp";
//	}
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("uuid") != null) {
			return "redirect:/books";
		}
  		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
	
//	@GetMapping("/books")
//	public String welcome(HttpSession session, Model model) {
//		if(session.getAttribute("uuid") == null) {
//			return "redirect:/logout";
//		}
//		
//		Long uuid = (Long) session.getAttribute("uuid");
//		model.addAttribute("user", userServ.getOne(uuid));
//		model.addAttribute("books", bookServ.getAll());
//		
//		return "book_add.jsp";
//	}
	
	
	// ========== Action ==========
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser")User newUser, BindingResult result, Model model, HttpSession session) {
		User user = userServ.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			
			return "index.jsp";
		}
		
		session.setAttribute("uuid", user.getId());		
		
		return "redirect:/books";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin , BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			
			return "index.jsp";
		}
		
		session.setAttribute("uuid", user.getId());
		
		
		return "redirect:/books";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		
		return "redirect:/";
	}
	
	
}











