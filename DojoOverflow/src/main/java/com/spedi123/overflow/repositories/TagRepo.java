package com.spedi123.overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.overflow.models.Question;
import com.spedi123.overflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
	Optional<Tag> findById(Long id);
	Optional<Tag> findBySubject(String subject);
	List<Tag> findAllByQuestions(Question question);
	List<Tag> findByQuestionsNotContains(Question question);
	
}
