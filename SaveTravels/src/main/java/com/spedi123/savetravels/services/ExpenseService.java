package com.spedi123.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spedi123.savetravels.models.Expense;
import com.spedi123.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// ===== Create / Update =====
	
	public Expense newExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	// ===== Read =====
	
	public List<Expense> getAll(){
		return expenseRepository.findAll();
	}
	
	public Expense getOne(Long id) {
		// Optional means the object can exist or not
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
	
	// ===== Delete =====
	
	public void delete(Long id) {
		expenseRepository.deleteById(id);
	}

}
