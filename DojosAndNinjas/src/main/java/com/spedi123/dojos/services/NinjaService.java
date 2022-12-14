package com.spedi123.dojos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.dojos.models.Ninja;
import com.spedi123.dojos.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// ========== Create / Update ==========

	public Ninja save(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	// ========== Read ==========

	public List<Ninja> getAll() {
		return ninjaRepo.findAll();
	}
	
	public Ninja getOne(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	
	// ========== Delete ==========

	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	}
	
}
