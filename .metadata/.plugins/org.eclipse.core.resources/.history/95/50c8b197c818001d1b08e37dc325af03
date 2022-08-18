package com.spedi123.springmodels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spedi123.springmodels.models.Dog;
import com.spedi123.springmodels.services.DogService;

@Controller
public class DogController {
// line 11~14 are same as line 17
//	private final DogService dogServ;
//	public DogController(DogService ds) {
//		this.dogServ = ds;
//	}
	
	@Autowired
	private DogService dogServ;
	
	// RESTful Routing Style
	// all routes, in general, take  certain structure
	// /<table_name>/action
	// /api/<table_name>/action
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dogs";
	}
	
	@GetMapping("/dogs")
	public String dogs(Model model) {
		List<Dog> listOfDogs = dogServ.getAll();
		
		model.addAttribute("listOfDogs", listOfDogs);
		return "index.jsp";
	}
}



















