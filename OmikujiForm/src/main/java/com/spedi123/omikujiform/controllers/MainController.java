package com.spedi123.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/submit")
	public String submitForm(
		@RequestParam(value="number") String number,
		@RequestParam(value="city") String city,
		@RequestParam(value="name") String name,
		@RequestParam(value="endeavor") String endeavor,
		@RequestParam(value="type") String type,
		@RequestParam(value="comment") String comment,
		HttpSession session
		){
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("endeavor", endeavor);
		session.setAttribute("type", type);
		session.setAttribute("comment", comment);
		
		return "redirect:/show";
	}

	@GetMapping("/show")
	public String dsplay(HttpSession session, Model model) {
		if (session.getAttribute("number")== null) {
			return "redirect:/";
		}
		
		model.addAttribute("crust", session.getAttribute("number"));
		model.addAttribute("cheese", session.getAttribute("city"));
		model.addAttribute("sauce", session.getAttribute("name"));
		model.addAttribute("topping", session.getAttribute("endeavor"));
		model.addAttribute("topping", session.getAttribute("type"));
		model.addAttribute("topping", session.getAttribute("comment"));
		
		return "show.jsp";
	}
}
