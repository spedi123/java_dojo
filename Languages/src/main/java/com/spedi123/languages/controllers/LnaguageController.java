package com.spedi123.languages.controllers;

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

import com.spedi123.languages.models.Language;
import com.spedi123.languages.services.LanguageService;

@Controller
public class LnaguageController {
	
	@Autowired
	private LanguageService languageServ;
	
	// Restful Routing Style
	//  /languages
	//  /languages (post)
	//  /languages/{id}
	//  /languages/{id}/edit
	//  /languages/{id}  (put)
	//  /languages/{id}  (delete)
	
	// ========== Display ==========
	
	@GetMapping("/")
	public String index() {
		return "redirect:/language";
	}

	
	@GetMapping("/languages")
	public String languages(@ModelAttribute("language") Language language, Model model) {
		List<Language> listOfLanguage = languageServ.getAll();
		model.addAttribute("languages", listOfLanguage);
		return "index.jsp"; 
	}
	
	@GetMapping("/languages/{id}")
	public String detail(@PathVariable("id")Long id, Model model) {
		Language language = languageServ.getOne(id);
		model.addAttribute("language", language);
		return "detail.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {	
		Language language = languageServ.getOne(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	// ========== Action ==========
	
	@PostMapping("/languages")
	public String index(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = languageServ.getAll();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}else {
			languageServ.create(language);
			return "redirect:/languages";
		}
	}
	
	@PutMapping("/languages/{id}/edit")
	public String updateLanguage(@Valid @ModelAttribute("language")Language language, BindingResult result, Model model){
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageServ.create(language);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/{id}/delete")
	public String deleteLanguage(@PathVariable("id")Long id) {
		languageServ.delete(id);
		return "redirect:/languages";
	}
}



























