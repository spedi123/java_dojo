package com.spedi123.dojos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spedi123.dojos.models.Ninja;
import com.spedi123.dojos.services.DojoService;
import com.spedi123.dojos.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired 
	private DojoService dojoServ;
	
	@Autowired 
	private NinjaService ninjaServ;
	
	@GetMapping("/ninjas/new")
	public String ninjas(@ModelAttribute("newNinja")Ninja newNinja, Model model) {
		model.addAttribute("dojos", dojoServ.getAll());
		model.addAttribute("ninjas", ninjaServ.getAll());
		return "addninja.jsp";				
	}
	
	
	@PostMapping("/ninjas/new")
	public String createToy(@Valid @ModelAttribute("newNinja")Ninja newNinja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoServ.getAll());
			model.addAttribute("ninjas", ninjaServ.getAll());
			return "add.jsp";
		} else {
			ninjaServ.save(newNinja);
			return "redirect:/dojos"; 
		}
	}
}
