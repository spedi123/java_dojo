package com.spedi123.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.bookclub.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
	
	List<Book> findAll();
	List<Book> findByUserIdIs(Long userId);
	List<Book> findByBorrowerIdIs(Long userId);
	List<Book> findByBorrowerIdIsOrUserIdIs(Long borrowerId, Long userId);
	
}