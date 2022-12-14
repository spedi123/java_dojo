package com.spedi123.studentroaster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.studentroaster.models.Dorm;
import com.spedi123.studentroaster.repositories.DormRepository;

@Service
public class DormService {
	
	@Autowired
	private DormRepository dormRepo; 
	
	// ========== Create / Update ==========
	
	public Dorm save(Dorm dorm) {
		return dormRepo.save(dorm);
	}
	
	// ========== Read ==========
	
	public List<Dorm> getAll() {
		return dormRepo.findAll();
	}
	
	public Dorm getOne(Long id) {
		Optional<Dorm> optDorm = dormRepo.findById(id);
		
		if (optDorm.isPresent()) {
			return optDorm.get();
		} else {
			return null;
		}
	}

	// ========== Delete ==========
	
	public void delete(Long id) {
		dormRepo.deleteById(id);
	}
}
