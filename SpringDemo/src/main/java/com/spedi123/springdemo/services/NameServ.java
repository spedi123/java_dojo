package com.spedi123.springdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.spedi123.springdemo.models.Name;
import com.spedi123.springdemo.repos.NameRepo;

@Service
public class NameServ {
	@Autowired
	private NameRepo repo;
	
	public NameServ(NameRepo repo) {
		this.repo = repo;
	}
	
	public List<Name> getAll(){
		return repo.findAll();
	}
	
	public Name getOne(Long id) {
		Optional<Name> opUser = repo.findById(id);
		if(!opUser.isPresent()) {
			return null;
		}
		return opUser.get();
	}
	public Name checkName(Name newName, BindingResult result) {

		if(repo.findByName(newName.getName()).isPresent()) {
			result.rejectValue("name", "unquie", "Name must be unique");
		}
		if(result.hasErrors()) {
			return null;
		} 
		return repo.save(newName);
	}
	
	public Name saveOne(Name name) {
		return repo.save(name);
	}
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
}