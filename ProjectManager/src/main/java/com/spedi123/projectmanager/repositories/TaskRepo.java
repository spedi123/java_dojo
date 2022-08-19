package com.spedi123.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.projectmanager.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
	List<Task> findAll();
	List<Task> findByProjectIdIs(Long id);
}
