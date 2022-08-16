package com.spedi123.beltexamdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedi123.beltexamdemo.models.Robot;

@Repository
public interface RobotRepo extends CrudRepository<Robot, Long> {
	List<Robot> findAll();
}
