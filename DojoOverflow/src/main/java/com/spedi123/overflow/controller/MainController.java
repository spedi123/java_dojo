package com.spedi123.overflow.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spedi123.overflow.models.Question;
import com.spedi123.overflow.models.Tag;
import com.spedi123.overflow.service.AnswerService;
import com.spedi123.overflow.service.QuestionService;
import com.spedi123.overflow.service.TagService;

@Controller
public class MainController {

	@Autowired
	private QuestionService questionServ;
	
	@Autowired
	private AnswerService answerServ;
	
	@Autowired
	private TagService tagServ;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Question> questions = questionServ.getAll();
		List<Tag> tags = tagServ.getAll();
		
		model.addAttribute("questions", questions);
		model.addAttribute("tags", tags);
		
		return "index.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQeustion(@ModelAttribute("newQuestion")Question newQuestion, Model model) {
		
		List<Tag> tags = tagServ.getAll();
		model.addAttribute("tags", tags);
		
		return "new_question.jsp";
	}
	
//	@PostMapping("/questions/new")
//	public String createQuestion(@Valid @ModelAttribute("newQuestion")Question newQuestion, BindingResult result, @RequestParam(value="listOfTags")String listOfTags, Model model) {
//
//		List<Tag> tags = tagServ.getAll();
//		model.addAttribute("tags", tags);
//		if(result.hasErrors()) {
//			return "new_question.jsp";
//		}
//		List<Tag> questionTags = checkTags(listOfTags);
//		if(questionTags != null) {
//			
//		}
//	}
	
	
}










