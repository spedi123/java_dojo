package com.spedi123.javaexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.javaexam.models.Course;
import com.spedi123.javaexam.models.Student;
import com.spedi123.javaexam.repositories.CourseRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;
	
	// ========== Create / Update ==========

	public Course create(Course course) {
		return courseRepo.save(course);
	}
	
	public Course update(Course course) {
		return courseRepo.save(course);
	}
	
	// ========== Read ==========

	public List<Course> getAll() {
		return courseRepo.findAll();
	}
	
	public Course getOne(Long id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	public List<Course> coursesInStudent(Student student) {
		return courseRepo.findAllByStudents(student);
	}
	
	public List<Course> coursesNotInStudent(Student student) {
		return courseRepo.findByStudentsNotContains(student);
	}
	
	// ========== Delete ==========
	
	public void delete(Long id) {
		courseRepo.deleteById(id);
	}
	
	
	
}











