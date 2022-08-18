package com.spedi123.javaexam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.javaexam.models.Course;
import com.spedi123.javaexam.models.Student;
import com.spedi123.javaexam.repositories.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	
	// ========== Create / Update ==========

	public Student create(Student student) {
		return studentRepo.save(student);
	}
	
	public Student update(Student student) {
		return studentRepo.save(student);
	}
	
	// ========== Read ==========
	
	public List<Student> getAll() {
		return studentRepo.findAll();
	}
	
	public Student getOne(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	
	public List<Student> studentsInCourse(Course course) {
		return studentRepo.findAllByCourses(course);
	}
	
	public List<Student> studentsNotInCourse(Course course) {
		return studentRepo.findByCoursesNotContains(course);
	}
	
	// ========== Delete ==========
	
	public void delete(Long id) {
		studentRepo.deleteById(id);
	}
}
