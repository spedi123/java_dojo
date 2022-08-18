package com.spedi123.javaexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.spedi123.javaexam.models.Course;
import com.spedi123.javaexam.models.Student;
import com.spedi123.javaexam.models.User;
import com.spedi123.javaexam.services.CourseService;
import com.spedi123.javaexam.services.StudentService;
import com.spedi123.javaexam.services.UserService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseServ;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private StudentService studentServ;
	
	// ========== Display ==========

	
	@GetMapping("/courses")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		List<Course> allcourses = courseServ.getAll();
		
		model.addAttribute("loggedInUser", user);
		model.addAttribute("allcourses", allcourses);
		
		return "course.jsp";
	}
	
	@GetMapping("/courses/new")
	public String newCourse(@ModelAttribute("newCourse")Course newCourse, HttpSession session ) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		return "course_new.jsp";
	}
	
	@GetMapping("/courses/{id}")
	public String oneCourse(@PathVariable("id")Long id,@ModelAttribute("newStudent")Student newStudent, HttpSession session, Model model) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		Course course = courseServ.getOne(id);
		model.addAttribute("loggedInUser", user);
		model.addAttribute("oneCourse", courseServ.getOne(id));
		model.addAttribute("studentsInCourse", studentServ.studentsInCourse(course));
		model.addAttribute("studentsNotInCourse", studentServ.studentsNotInCourse(course));
		
		return "course_detail.jsp";
	}
	
	@GetMapping("/courses/{id}/edit")
	public String editRobot(@PathVariable("id")Long id, HttpSession session, Model model) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		model.addAttribute("course", courseServ.getOne(id));
		
		return "course_edit.jsp";
	}
	
	// ========== Action ==========
	
	
	@PostMapping("/courses/new")
	public String createCourse(@Valid @ModelAttribute("newCourse")Course newCourse, BindingResult result, HttpSession session)  {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "course_new.jsp";
		}
		
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		newCourse.setInstructor(user);
		
		courseServ.create(newCourse);
		
		return "redirect:/courses";
	}
	
	@PostMapping("/courses/{id}/createStudent")
	public String createStudent(@PathVariable("id")Long id, @Valid @ModelAttribute("newStudent")Student newStudent, BindingResult result, HttpSession session) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "course_detail.jsp";
		}
		
		studentServ.create(newStudent);
		
		return "redirect:/courses/"+id;
	}
		
	
	@PostMapping("/courses/{id}/participateClass")
	public String createStudent(@PathVariable("id")Long id, @RequestParam(value="studentId")Long studentId, HttpSession session, Model model) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}

		Course course = courseServ.getOne(id);
		Student student = studentServ.getOne(studentId);
		course.getStudents().add(student);
		courseServ.update(course);
		model.addAttribute("studentsInCourse", studentServ.studentsInCourse(course));
		model.addAttribute("studentsNotInCourse", studentServ.studentsNotInCourse(course));
		
		return "redirect:/courses/"+id;
	}
		
	
	@PutMapping("/courses/{id}/update")
	public String updateRobot(@PathVariable("id")Long id, @Valid @ModelAttribute("course")Course course, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "course_edit.jsp";
		}
		
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		Course courseFromDB = courseServ.getOne(id);
		if (courseFromDB.getInstructor().getId() != user.getId()) {
			return "redirect:/robots";
		} 
		
		course.setInstructor(user);
		courseServ.update(course);
		
		return "redirect:/courses/" + id;
	}
	
	@DeleteMapping("/courses/{id}/delete")
	public String deleteCourse(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		Course course = courseServ.getOne(id);
		if (course.getInstructor().getId() != user.getId()) {
			return "redirect:/courses";
		}
		courseServ.delete(id);
		
		return "redirect:/courses";
	}
	
}
