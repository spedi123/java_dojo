package com.spedi123.savetravels.controllers;

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

import com.spedi123.savetravels.models.Expense;
import com.spedi123.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.getAll();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {	
		Expense expense = expenseService.getOne(id);	
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PostMapping("/expenses")
	public String index(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.getAll();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}else {
			expenseService.newExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	
	@PutMapping("/expenses/{id}/edit")
	public String updateExpense(@Valid @ModelAttribute("expense")Expense expense, BindingResult result, @PathVariable("id")Long id) {
		if (result.hasErrors()) {
			return "editExpense.jsp";
		} else {
			expenseService.newExpense(expense);
			
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping("/expenses/{id}/delete")
	public String deleteExpense(@PathVariable("id")Long id) {
		expenseService.delete(id);
		return "redirect:/expenses";
	}
}