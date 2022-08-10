package com.spedi123.travel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spedi123.travel.models.Expense;
import com.spedi123.travel.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseServ;
	
	// ===== Display =====
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expense";
	}
	
	@GetMapping("/expense")
	public String expense(Model model) {
		List<Expense> listOfExpense = expenseServ.getAll();
		model.addAttribute("expense", listOfExpense);
		
		return "index.jsp";
	}
	
	@GetMapping("/expense/new")
	public String newExpense(@ModelAttribute("newExpense")Expense newExpense) {
		return "index.jsp";
	}
	
	// ===== Action =====
	
	@PostMapping("expense/create")
	public String createExpense(@ModelAttribute("newExpense")Expense newExpense, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		
		expenseServ.save(newExpense);
		
		return "redirect:/expense";
	}
	
	
}
