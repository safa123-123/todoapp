package com.safa.springboot.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safa.springboot.webservice.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	public List<Task> findAllByUserId(Long userId);

}
