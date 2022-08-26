package com.spedi123.springdemo.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spedi123.springdemo.models.LoginUser;
import com.spedi123.springdemo.models.User;
import com.spedi123.springdemo.services.UserServ;

@Controller
public class LoginController {
	 private final UserServ serv;
	 public LoginController(UserServ serv) {
	 	this.serv = serv;
	 }
@RequestMapping("/") //this could be different
	public String loadLoginReg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "login.jsp";
	}
@RequestMapping("/register")
	public String checkReg(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User user = serv.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "/login.jsp"; // set a return redirect here
		} else {

			session.setAttribute("uuid", user.getId());
			 return "redirect:/home"; // set a return redirect here
		}
	}
	@RequestMapping("/login")
	public String checkLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User user = serv.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "/login.jsp";  // set a return redirect here
		}

		session.setAttribute("uuid", user.getId());
			return "redirect:/home"; // set a return redirect here
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		return "redirect:/";
	}
}