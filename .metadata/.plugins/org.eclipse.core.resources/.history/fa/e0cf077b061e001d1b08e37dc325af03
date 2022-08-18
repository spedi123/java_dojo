package com.spedi123.prodcutsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.prodcutsandcategories.models.Category;
import com.spedi123.prodcutsandcategories.models.Product;
import com.spedi123.prodcutsandcategories.repositories.CategoryRepo;

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
	
	public List<Category> getAll() {
		return categoryRepo.findAll();
	}
	
	public Category getOne(Long id) {
		Optional<Category> optCategory = categoryRepo.findById(id);
		if(optCategory.isPresent()) {
			return optCategory.get();
		}else {
			return null;
		}
	}
	
	public List<Category> categoriesInProduct(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> categoriesNotInProduct(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
	
	
	// ========== Delete ==========
	
	public void delete(Long id) {
		categoryRepo.deleteById(id);
	}
	
}

















