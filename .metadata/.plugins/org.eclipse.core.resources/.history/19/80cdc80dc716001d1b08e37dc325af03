package com.spedi123.displaydate.controller;

import java.text.SimpleDateFormat;
import java.time.format.FormatStyle;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	 @RequestMapping("/")
	 public String index() {
		 return "Index.jsp";
	 }
	 
	 @RequestMapping("/date")
	 public String date(Model model) {
		 SimpleDateFormat dayNameFormat = new SimpleDateFormat("EEEE");
		 SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		 SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
    	 SimpleDateFormat yearFormat = new SimpleDateFormat("Y");
    	
    	 Date currentDate = new Date();
    	
    	 String dayNameString = dayNameFormat.format(currentDate);
    	 String dayString = dayFormat.format(currentDate);
    	 String monthString = monthFormat.format(currentDate);
    	 String yearString = yearFormat.format(currentDate);
    	
    	 String dateString = dayNameString + ", " + "the " + dayString + " of " + monthString + ", " + yearString;
		 
    	 model.addAttribute("dateString", dateString);
		 
		 return "Date.jsp";
	 }
	 
	 @RequestMapping("/time")
	 public String time(Model model) {
		 SimpleDateFormat timeForm = new SimpleDateFormat("h:m a");
		 Date currentTime = new Date();
		 String timeString = timeForm.format(currentTime);
		 model.addAttribute("timeString", timeString);
		 return "Time.jsp";
	 }
	 
}
