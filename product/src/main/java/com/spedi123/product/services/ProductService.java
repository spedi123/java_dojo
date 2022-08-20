package com.spedi123.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.product.models.Category;
import com.spedi123.product.models.Product;
import com.spedi123.product.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	// ========== Create / Update ==========
	
	public Product create(Product product) {
		return productRepo.save(product);
	}
	
	public Product update(Product product) {
		return productRepo.save(product);
	}
	
	// ========== Read ==========

	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
	public Product getOne(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public List<Product> getAssignedCategories(Category category) {
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> getUnassignedCategories(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}

	
	
	// ========== Delete ==========
	
	public void delete(Long id) {
		productRepo.deleteById(id);
	}
}
