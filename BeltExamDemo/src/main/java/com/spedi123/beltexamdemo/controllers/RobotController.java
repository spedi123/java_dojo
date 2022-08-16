package com.spedi123.beltexamdemo.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.spedi123.beltexamdemo.models.Robot;
import com.spedi123.beltexamdemo.models.User;
import com.spedi123.beltexamdemo.services.RobotService;
import com.spedi123.beltexamdemo.services.UserService;

@Controller
@RequestMapping("/robots")

public class RobotController {
	
	@Autowired
	private RobotService robotServ;
	
	@Autowired
	private UserService userServ;
	
	// ========== Display ==========

	@GetMapping("")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		List<Robot> allRobots = robotServ.getAll();
		
		model.addAttribute("loggedInUser", user);
		model.addAttribute("allRobots", allRobots);
		
		return "robots.jsp";
	}
	
	@GetMapping("/{id}") 
	public String oneRobot(@PathVariable("id")Long id, HttpSession session, Model model) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		model.addAttribute("loggedInUser", user);
		model.addAttribute("oneRobot", robotServ.getOne(id));
		
		return "oneRobot.jsp";
	}
	
	@GetMapping("/new")
	public String newRobot(@ModelAttribute("newRobot")Robot newRobot, HttpSession session ) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		return "newRobot.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String editRobot(@PathVariable("id")Long id, HttpSession session, Model model) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		
		model.addAttribute("robot", robotServ.getOne(id));
		
		return "editRobot.jsp";
	}
	
	
	// ========== Action ==========
	
	@PostMapping("/create")
	public String createRobot(@Valid @ModelAttribute("newRobot")Robot newRobot, BindingResult result, HttpSession session)  {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "newRobot.jsp";
		}
		
		// this code actually makes the relationship between user and robot
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		newRobot.setCreator(user);
		
		robotServ.save(newRobot);
		
		return "redirect:/robots";
	}
	
	@PutMapping("/{id}/update")
	public String updateRobot(@PathVariable("id")Long id, @Valid @ModelAttribute("robot")Robot robot, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "editRobot.jsp";
		}
		
		// check if the user actually made this robot
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		Robot robotFromDB = robotServ.getOne(id);
		if (robotFromDB.getCreator().getId() != user.getId()) {
			return "redirect:/robots";
		} 
		
		robot.setCreator(user);
		robotServ.save(robot);
		
		return "redirect:/robots/" + id;
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteRobot(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		Robot robot = robotServ.getOne(id);
		if (robot.getCreator().getId() != user.getId()) {
			return "redirect:/robots";
		}

		
		robotServ.delete(id);
		
		return "redirect:/robots";
	}
	
}


















