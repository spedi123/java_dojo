package com.spedi123.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spedi123.dojos.models.Dojo;
import com.spedi123.dojos.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoServ;
	
	
	// ========== Display ==========
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String main(@ModelAttribute("dojo")Dojo dojo, Model model) {
		List<Dojo> dojos = dojoServ.getAll();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String dojoDetail(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojos", dojoServ.getOne(id));
		return "dojodetail.jsp";
	}
	
	// ========== Action ==========
	
	@PostMapping("/dojos/new")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoServ.getAll();
			model.addAttribute("dojos", dojos);
			return "index.jsp";
		}
		dojoServ.save(dojo);
		return "redirect:/dojos";
	}
	
	
}
