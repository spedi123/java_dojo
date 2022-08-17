package com.spedi123.prodcutsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.prodcutsandcategories.models.Category;
import com.spedi123.prodcutsandcategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	
	List<Category> findAll();
	Optional<Category> findById(Long id);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);

}
