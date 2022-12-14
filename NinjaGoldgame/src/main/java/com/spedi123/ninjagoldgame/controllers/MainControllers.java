package com.spedi123.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControllers {
	
	@GetMapping("/")
	public String index(HttpSession session) {
		return "index.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/gold")
	public String submitForm(
		@RequestParam(value="farm") String farm,
		@RequestParam(value="cave") String cave,
		@RequestParam(value="house") String house,
		@RequestParam(value="quest") String quest,
		HttpSession session,
		Model model
	){
		SimpleDateFormat dateForm = new SimpleDateFormat("MMMM D Y h:mm a");
		
		Integer gold = 0; 
		ArrayList<String> activities = new ArrayList<>();
		
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", activities);
		} else {
			gold = (Integer) session.getAttribute("gold");
			activities = (ArrayList<String>) session.getAttribute("activities");
			session.setAttribute("activities", activities);
		}
		
		if (farm != null) {
			Integer amount = new Random().nextInt(11)+10;
			gold += amount;
			
			session.setAttribute("gold", gold);
			activities.add(0, "You entered a farm and earned" + amount + "gold. (" + dateForm.format(new Date())+ ")");
			
			return "redirect:/gold";
		}
		
		if (cave != null) {
			Integer amount = new Random().nextInt(6)+5;
			gold += amount;
			
			session.setAttribute("gold", gold);
			activities.add(0, "You entered a cave and earned" + amount + "gold. (" + dateForm.format(new Date())+ ")");
			
			return "redirect:/gold";
		}
		
		if (house != null) {
			Integer amount = new Random().nextInt(4)+2;
			gold += amount;
			
			session.setAttribute("gold", gold);
			activities.add(0, "You entered a house and earned" + amount + "gold. (" + dateForm.format(new Date())+ ")");
			
			return "redirect:/gold";
		}

		if (quest != null) {
			Integer amount = new Random().nextInt(101) - 50;
			gold += amount;
			
			session.setAttribute("gold", gold);
			if (amount < 0 ) {
				activities.add(0, "You failed a quest and lost" + (amount * -1) + "gold. (" + dateForm.format(new Date())+ ")");
			} else {
				activities.add(0, "You entered a quest and earned" + amount + "gold. (" + dateForm.format(new Date())+ ")");	
			}
			
			return "redirect:/gold";
		}
		return "index.jsp";
	}	
}







