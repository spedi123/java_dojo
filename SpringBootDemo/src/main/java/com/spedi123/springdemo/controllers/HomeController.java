package com.spedi123.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/pizza/{number}")
	public String pizza(@PathVariable("number")String number) {
		return "I like pizza3";
	}
	
}
