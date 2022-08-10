package com.spedi123.travel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="expense")
public class Expense {
	
	// ===== Primary Key =====
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// ===== Member Variables =====
	 
	@NotNull
	@Size(min = 2, max =128)
	private String expense;
	 
	@NotNull
	@Size(min = 2, max =128)
	private String vendor;
	 
	@NotNull
	@Min(0)
	private Double amount;
	
	@NotNull
	@Size(min = 1, max =200)
	private String description;
	 
  
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	
	// ===== Constructors =====
	
	public Expense() {}
	
	public Expense(String expense, String vendor, Double amount, String description) {
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	 
	// ===== Getters and Setters =====
	 
	public Long getId() {
			return id;
	}
	 
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
