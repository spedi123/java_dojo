package com.spedi123.studentroaster.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.spedi123.studentroaster.models.Student;
import com.spedi123.studentroaster.services.DormService;
import com.spedi123.studentroaster.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentServ;
	
	@Autowired
	private DormService dormServ;
	
	
	// ========== Display ==========

	@GetMapping("/students/new")
	public String studnets(@ModelAttribute("newStudent")Student newStudent, Model model) {
		model.addAttribute("dorms", dormServ.getAll());
		model.addAttribute("students", studentServ.getAll());
		return "add_student.jsp";				
	}
	
	// ========== Action ==========

	@PostMapping("/students/new")
	public String addStudent(@Valid @ModelAttribute("newStudent")Student newStudent, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dormServ.getAll());
			model.addAttribute("ninjas", studentServ.getAll());
			return "add_student.jsp";
		} else {
			studentServ.save(newStudent);
			return "redirect:/dorms"; 
		}
	}
	
	@PutMapping("/students/update/{dorm_id}")
	public String updateStudentDorm(@PathVariable("dorm_id")Long dorm_id, @ModelAttribute("student")Student student) {
		Student updateStudent = studentServ.getOne(student.getId());
		updateStudent.setDorm(dormServ.getOne(dorm_id));
		studentServ.save(updateStudent);
		return "redirect:/dorms/"+dorm_id;
	}
	
}
