package com.spedi123.studentroaster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.studentroaster.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {
	
	List<Dorm> findAll();

}
