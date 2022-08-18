package com.spedi123.javaexam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.javaexam.models.Course;
import com.spedi123.javaexam.models.Student;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
	List<Course> findAll();
	Optional<Course> findById(Long id);
	List<Course> findAllByStudents(Student student);
	List<Course> findByStudentsNotContains(Student student);
}
