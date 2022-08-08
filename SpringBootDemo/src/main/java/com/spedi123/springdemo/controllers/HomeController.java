package com.spedi123.springdemo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(){
		return "index.jsp";
	}
	
	@PostMapping("/submit")
	public String submitForm(
		@RequestParam(value="crust") String crust,
		@RequestParam(value="cheese") String cheese,
		@RequestParam(value="sauce") String sauce,
		@RequestParam(value="topping") String topping,
		HttpSession session
		){
		session.setAttribute("crust", crust);
		session.setAttribute("cheese", cheese);
		session.setAttribute("sauce", sauce);
		session.setAttribute("topping", topping);
		
		return "redirect:/display";
	}

	@GetMapping("/display")
	public String dsplay(HttpSession session, Model model) {
		if (session.getAttribute("crust")== null) {
			return "redirect:/";
		}
		
		model.addAttribute("crust", session.getAttribute("crust"));
		model.addAttribute("cheese", session.getAttribute("cheese"));
		model.addAttribute("sauce", session.getAttribute("sauce"));
		model.addAttribute("topping", session.getAttribute("topping"));
		
		return "results.jsp";
	}
}