package com.spedi123.studentroaster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.studentroaster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	
	List<Student> findAll();

}
