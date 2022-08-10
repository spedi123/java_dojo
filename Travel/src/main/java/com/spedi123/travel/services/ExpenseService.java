package com.spedi123.travel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.travel.models.Expense;
import com.spedi123.travel.repositories.ExpenseRepository;

@Service
public class ExpenseService {
//	private final ExpenseRepository expenseRepo;
//	
//	public ExpenseService(ExpenseRepository expenseRepo) {
//		this.expenseRepo = expenseRepo;
//	}
	@Autowired
	private ExpenseRepository expenseRepo;
	
	// ===== Create / Update =====
	
	public Expense save(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	// ===== Read ======
	
	public List<Expense> getAll() {
		return expenseRepo.findAll();
	}
	
	public Expense getOne(Long id) {
		Optional<Expense> optExpense = expenseRepo.findById(id);

		if (optExpense.isPresent()) {
			return optExpense.get();
		} else {
			return null;
		}
	}

	// ===== Delete =====
	
	public void delete(Long id) {
		expenseRepo.deleteById(id);
	}
}	
