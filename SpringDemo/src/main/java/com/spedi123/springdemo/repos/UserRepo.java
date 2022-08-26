package com.spedi123.springdemo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.springdemo.models.Name;
import com.spedi123.springdemo.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findAll();
	Optional<User> findByEmail(String email); 
	List<User> findAllByName(Name name);
	List<User> findByNameNotContains(Name name);
}