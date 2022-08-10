package com.spedi123.springmodels.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.springmodels.models.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long>{
	List<Dog>findAll();
	
	List<Dog> findAllByHairColor(String hairColor);
}
