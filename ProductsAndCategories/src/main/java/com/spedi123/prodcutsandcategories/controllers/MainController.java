package com.spedi123.prodcutsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spedi123.prodcutsandcategories.models.Category;
import com.spedi123.prodcutsandcategories.models.Product;
import com.spedi123.prodcutsandcategories.services.CategoryService;
import com.spedi123.prodcutsandcategories.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private CategoryService categoryServ;
	
	@Autowired
	private ProductService productServ;
	
	// ========== Display ==========

	@GetMapping("/")
	public String index(Model model) {
		
		List<Product> products = productServ.getAll();
		List<Category> categories = categoryServ.getAll();
		
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		return "product_new.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category")Category category) {
		return "category_new.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String productDetail(@PathVariable("id")Long id, Model model) {
		
		Product product = productServ.getOne(id);		
		model.addAttribute("categoriesInProduct", categoryServ.categoriesInProduct(product));
		model.addAttribute("categoriesNotInProduct", categoryServ.categoriesNotInProduct(product));
		model.addAttribute("product", product);
		
		return "product_show.jsp";
	}
	
	@GetMapping("/categories/{id}")
	public String categoryDetail(@PathVariable("id")Long id, Model model) {
		
		Category category = categoryServ.getOne(id);
		model.addAttribute("productsInCategory", productServ.productsInCategory(category));
		model.addAttribute("productsNotInCategory", productServ.productsNotInCategory(category));
		model.addAttribute("category", categoryServ.getOne(id));
		
		return "category_show.jsp";
	}
	
	// ========== Action ==========
	
	@PostMapping("products/new")
	public String createProduct(@Valid @ModelAttribute("product")Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "product_new.jsp";
		} 
		
		productServ.create(product);
		return "redirect:/";
		
	}
	
	@PostMapping("categories/new")
	public String createCategory(@Valid @ModelAttribute("category")Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "category_new.jsp";
		} 
		
		categoryServ.create(category);
		return "redirect:/";
		
	}
	
	@PostMapping("/products/{id}")
	public String updateProduct(@PathVariable("id")Long id, @RequestParam(value="categoryId")Long categoryId, Model model) {
		
		Product product = productServ.getOne(id);
		Category category = categoryServ.getOne(categoryId);
		product.getCategories().add(category);
		productServ.update(product);
		model.addAttribute("categoriesInProduct", categoryServ.categoriesInProduct(product));
		model.addAttribute("categoriesNotInProduct", categoryServ.categoriesNotInProduct(product));
		
		return "redirect:/products/"+id;
	}
	
	@PostMapping("/categories/{id}")
	public String updateCategory(@PathVariable("id")Long id, @RequestParam(value="productId")Long productId, Model model) {
		
		Category category = categoryServ.getOne(id);
		Product product = productServ.getOne(productId);
		category.getProducts().add(product);
		categoryServ.update(category);
		model.addAttribute("productsInCategory", productServ.productsInCategory(category));
		model.addAttribute("productsNotInCategory", productServ.productsNotInCategory(category));
		
		return "redirect:/categories/"+id;
	}
	
	
}


















