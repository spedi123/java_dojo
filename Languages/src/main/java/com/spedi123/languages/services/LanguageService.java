package com.spedi123.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spedi123.languages.models.Language;
import com.spedi123.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
//	@Autowired
//	private LanguageRepository languageRepo;
	
	// ========== Create / Update ==========
	
	public Language create(Language language) {
		return languageRepo.save(language);
	}

	// ========== Read ==========

	public List<Language> getAll() {
		return languageRepo.findAll();
	}
	
	public Language getOne(Long id) {
		Optional<Language> optLanguage = languageRepo.findById(id);
		
		if (optLanguage.isPresent()) {
			return optLanguage.get();
		} else {
			return null;
		}
		
	}
	
	// ========== Delete ==========
	
	public void delete(Long id) {
		languageRepo.deleteById(id);
	}
}












