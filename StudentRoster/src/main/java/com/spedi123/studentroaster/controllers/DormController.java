package com.spedi123.studentroaster.controllers;

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

import com.spedi123.studentroaster.models.Dorm;
import com.spedi123.studentroaster.models.Student;
import com.spedi123.studentroaster.services.DormService;
import com.spedi123.studentroaster.services.StudentService;

@Controller
public class DormController {
	
	@Autowired 
	private DormService dormServ;
	
	@Autowired
	private StudentService studentServ;
	
	// ========== Display ==========
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dorms";
	}
	
	@GetMapping("/dorms")
	public String main(@ModelAttribute("dorm")Dorm dorm, Model model) {
		List<Dorm> dorms = dormServ.getAll();
		model.addAttribute("dorms", dorms);
		return "index.jsp";
	}
	
	@GetMapping("/dorms/{id}")
	public String dormDetail(@PathVariable("id")Long id,@ModelAttribute("student")Student student, Model model) {
		List<Student> listOfStudents = studentServ.getAll();
		model.addAttribute("listOfStudents", listOfStudents);
		model.addAttribute("dorms", dormServ.getOne(id));
		return "detail_dorm.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String addDorm(@ModelAttribute("dorm") Dorm dorm, Model model) {
		List<Dorm> dorms = dormServ.getAll();
		model.addAttribute("dorms", dorms);
		return "add_dorm.jsp";
	}
			

	// ========== Action ==========
	
	@PostMapping("/dorms/new")
	public String create(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dorm> dorms = dormServ.getAll();
			model.addAttribute("dorms", dorms);
			return "index.jsp";
		}
		dormServ.save(dorm);
		return "redirect:/dorms";
	}
}
