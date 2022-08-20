package com.spedi123.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.product.models.Category;
import com.spedi123.product.models.Product;
import com.spedi123.product.repositories.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	// ========== Create / Update ==========

	public Category create(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category update(Category category) {
		return categoryRepo.save(category);
	}
	
	// ========== Read ==========

	public List<Category> getAll(){
		return categoryRepo.findAll();
	}
	
	
	public Category getOne(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public List<Category> getAssignedProducts(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	
	public List<Category> getUnassignedProducts(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
 	
	// ========== Delete ==========
	
	public void delete(Long id) {
		categoryRepo.deleteById(id);
	}
}
