package com.spedi123.javaexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spedi123.javaexam.models.LoginUser;
import com.spedi123.javaexam.models.User;
import com.spedi123.javaexam.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	// ========== Display ==========

//	@GetMapping("/")
//	public String index(@ModelAttribute("newUser")User newUser, @ModelAttribute("newLogin")LoginUser newLogin) {
//		return "index.jsp";
//	}
	
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("uuid") != null) {
			return "redirect:/courses";
		}
  		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
	
//	@GetMapping("/dashboard")
//	public String welcome(HttpSession session, Model model) {
//		if(session.getAttribute("uuid") == null) {
//			return "redirect:/logout";
//		}
//		
//		Long uuid = (Long) session.getAttribute("uuid");
//		model.addAttribute("user", userServ.getOne(uuid));
//		
//		return "welcome.jsp";
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
		
		return "redirect:/courses";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin , BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			
			return "index.jsp";
		}
		
		session.setAttribute("uuid", user.getId());
		
		
		return "redirect:/courses";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		
		return "redirect:/";
	}
	
	
}












