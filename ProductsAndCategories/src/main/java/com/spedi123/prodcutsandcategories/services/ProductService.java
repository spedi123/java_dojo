package com.spedi123.prodcutsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.prodcutsandcategories.models.Category;
import com.spedi123.prodcutsandcategories.models.Product;
import com.spedi123.prodcutsandcategories.repositories.ProductRepo;

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
		Optional<Product> optProduct = productRepo.findById(id);
		if(optProduct.isPresent()) {
			return optProduct.get();
		}else {
			return null;
		}
	}
	
	public List<Product> productsInCategory(Category category) {
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> productsNotInCategory(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	// ========== Delete ==========
	
	public void delete(Long id) {
		productRepo.deleteById(id);
	}
	
	
}













