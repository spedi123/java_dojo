package com.spedi123.beltexamdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.beltexamdemo.models.Robot;
import com.spedi123.beltexamdemo.repositories.RobotRepo;

@Service
public class RobotService {

	@Autowired
	private RobotRepo robotRepo;
	
	
	// ========== Create / Update ==========
	
	public Robot save(Robot robot) {
		return robotRepo.save(robot);
	}
	// ========== Read ==========
	
	public List<Robot> getAll() {
		return robotRepo.findAll();
	}
	
	public Robot getOne(Long id) {
		return robotRepo.findById(id).orElse(null);
	}

	// ========== Delete ==========
	
	public void delete(Long id) {
		robotRepo.deleteById(id);
	}
}
