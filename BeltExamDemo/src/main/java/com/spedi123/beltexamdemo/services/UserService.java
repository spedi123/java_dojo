package com.spedi123.beltexamdemo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.spedi123.beltexamdemo.models.LoginUser;
import com.spedi123.beltexamdemo.models.User;
import com.spedi123.beltexamdemo.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	// ========== Register and Login  ==========
	
	public User register (User newUser, BindingResult result) {
		
		// Check if the email is unique
		if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "Email is already in use.");
		}
		
		// Check if the password matches the confirm password
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password!");
		}
		
		// Final check to see if there are errors
		if(result.hasErrors()) {
			return null;
		}
		
		String hash_browns = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hash_browns);
		
		return userRepo.save(newUser);
	}
	
	public User login (LoginUser newLoginUser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		
		// check to see if the user with the entered email exists
		Optional<User> potentialUser = userRepo.findByEmail(newLoginUser.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Invalid Credentials");
			// if the email is not found, don't bother checking the password
			return null;
		}
		
		
		User user = potentialUser.get();
		if (!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Credentials");
			
			return null;
		}
		return user;
	}
	

	// ========== Read ==========
	
	public User getOne(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	
}
