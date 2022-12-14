package com.spedi123.studentroaster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.studentroaster.models.Student;
import com.spedi123.studentroaster.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	// ========== Create / Update ==========
	
	public Student save(Student student) {
		return studentRepo.save(student);
	}
	
	// ========== Read ==========
	
	public List<Student> getAll() {
		return studentRepo.findAll();
	}
	
	public Student getOne(Long id) {
		return studentRepo.findById(id).orElse(null);
	}

	// ========== Delete ==========
	
	public void delete(Long id) {
		studentRepo.deleteById(id);
	}
}
