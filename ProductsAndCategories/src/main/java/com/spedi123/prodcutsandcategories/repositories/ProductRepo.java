package com.spedi123.prodcutsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.prodcutsandcategories.models.Category;
import com.spedi123.prodcutsandcategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	Optional<Product> findById(Long id);
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
	
}
