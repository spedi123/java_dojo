package com.spedi123.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.bookclub.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
	
	List<Book> findAll();
	public Book findByTitle(String title);
	List<Book> findByUserIdIs(Long userId);
}