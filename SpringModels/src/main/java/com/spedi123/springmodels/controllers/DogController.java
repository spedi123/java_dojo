package com.spedi123.springmodels.controllers;

import java.util.List;

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
	
	// ====== Display =====
	
	@GetMapping("/dogs")
	public String dogs(Model model) {
		List<Dog> listOfDogs = dogServ.getAll();
		
		model.addAttribute("listOfDogs", listOfDogs);
		
		return "dogs/index.jsp";
	}
	
	
	@GetMapping("/dogs/new")
	public String newDog(@ModelAttribute("newDog")Dog newDog) {
//		model.addAttributoe("newDog", new Dog());
		
		return "dogs/newDog.jsp";
	}
	
	@GetMapping("/dogs/{id}")
	public String oneDog(@PathVariable("id")Long id, Model model) {
		// bottom 2 line is same as line 3;
//		Dog thisDog = dogServ.getOne(id);
//		model.addAttribute("dog", thisDog);
		
		model.addAttribute("dog", dogServ.getOne(id));
		
		
		return "dogs/oneDog.jsp";
	}
	
	@GetMapping("/dogs/{id}/edit")
	public String editDog(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dog", dogServ.getOne(id));
		return "dogs/editDog.jsp";
	}
	
	// ===== Action ======
	
	@PostMapping("/dogs/create")
	public String createDog(@Valid @ModelAttribute("newDog") Dog newDog, BindingResult result) {
		if (result.hasErrors()) {
            return "dogs/newDog.jsp";
        } 
		
		dogServ.save(newDog);
		
	return "redirect:/dogs";
	}
	
	@PutMapping("/dogs/{id}/update")
	public String updateDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, @PathVariable("id")Long id) {
		
		if (result.hasErrors()) {
            return "dogs/editDog.jsp";
        } 
		
		dogServ.save(dog);
		
		return "redirect:/dogs/" + id;
	}
	
	@DeleteMapping("/dogs/{id}/delete")
	public String delteDog(@PathVariable("id")Long id) {
		dogServ.delete(id);
		
		return "redirect:/dogs";
	}
}



















