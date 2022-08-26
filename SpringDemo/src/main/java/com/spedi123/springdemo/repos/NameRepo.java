package com.spedi123.springdemo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.springdemo.models.Name;
import com.spedi123.springdemo.models.User;

@Repository
public interface NameRepo extends CrudRepository<Name, Long>{
	List<Name> findAll();
	Optional<Name> findByName(String name);
	List<Name> findAllByUser(User user);
	List<Name> findByUserNotContains(User user);
}
