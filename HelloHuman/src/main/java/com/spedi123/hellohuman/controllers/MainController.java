package com.spedi123.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
	public String hello(
			@RequestParam(value="first_name", required=false) String firstName, 
			@RequestParam(value="last_name", required=false) String lastName,
			@RequestParam(value="times", required=false) String times)
	{
		String result = "";
		if(firstName != null && lastName != null) { 
			result =  "Hello, " + firstName + " " + lastName;
		}
		else if (firstName != null) {
			result = "Hello, " + firstName;
		}
		else {
			result = "Hello, Human";
		}
		
		if (times != null ) {
			int greet = Integer.parseInt(times);
			for (int i=1; i<=greet; i++) {
				if(lastName != null) {
					result += " Hello, " + firstName + " " + lastName;
				}
				else {
					result +=  "Hello, " + firstName;
				}
			}
		}
		return result;
		
	}
}
