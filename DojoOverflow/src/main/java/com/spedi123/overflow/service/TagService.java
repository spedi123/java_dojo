package com.spedi123.overflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedi123.overflow.models.Question;
import com.spedi123.overflow.models.Tag;
import com.spedi123.overflow.repositories.TagRepo;

@Service
public class TagService {
	
	@Autowired
	private TagRepo tagRepo;
	
	// ========== Create / Update ==========
	
	public Tag create(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public Tag update(Tag tag) {
		return tagRepo.save(tag);
	}
	
	// ========== Read ==========
	
	public List<Tag> getAll() {
		return tagRepo.findAll();
	}
	
	public Tag getOne(Long id) {
		return tagRepo.findById(id).orElse(null);
	}
	
	public List<Tag> getAssignedQuestions(Question question) {
		return tagRepo.findAllByQuestions(question);
	}
	
	public List<Tag> getUnassignedQuestions(Question question) {
		return tagRepo.findByQuestionsNotContains(question);
	}

	// ========== Delete ==========
	
	
	public void delete(Long id) {
		tagRepo.deleteById(id);
	}
	
	
}










