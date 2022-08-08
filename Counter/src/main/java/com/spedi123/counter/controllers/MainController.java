package com.spedi123.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer counter = (Integer) session.getAttribute("counter");
		if (counter == null) {
			session.setAttribute("counter", 1);
		} else {
			session.setAttribute("counter", counter+=1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer counter = 0;
		
		if(session.getAttribute("counter") == null) {
			session.setAttribute("counter", 1);
		} else {
			counter = (Integer) session.getAttribute("counter");
		}
		
		model.addAttribute("counter", counter);
		
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCounter (HttpSession session) {
		session.setAttribute("counter", 0);
		return "redirect:/counter";
	}
}
