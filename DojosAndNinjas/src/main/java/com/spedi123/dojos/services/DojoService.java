package com.spedi123.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.dojos.models.Dojo;
import com.spedi123.dojos.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository dojoRepo;
	
	// ========== Create / Update ==========
	
	public Dojo save(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	// ========== Read ==========

	public List<Dojo> getAll() {
		return dojoRepo.findAll();
	}
	
	public Dojo getOne(Long id) {
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		
		if (optDojo.isPresent()) {
			return optDojo.get();
		} else {
			return null;
		}
	}
	
	// ========== Delete ==========
	
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	}
	
}













