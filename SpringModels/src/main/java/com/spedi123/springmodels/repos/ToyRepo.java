package com.spedi123.springmodels.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.springmodels.models.Toy;

@Repository
public interface ToyRepo extends CrudRepository<Toy, Long> {
	List<Toy> findAll();
}
