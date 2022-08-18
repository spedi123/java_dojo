package com.spedi123.javaexam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.javaexam.models.Course;
import com.spedi123.javaexam.models.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
	List<Student> findAll();
	Optional<Student> findById(Long id);
	List<Student> findAllByCourses(Course course);
	List<Student> findByCoursesNotContains(Course course);
}
