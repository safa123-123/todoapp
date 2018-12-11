package com.safa.springboot.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.safa.springboot.webservice.model.TaskItems;

@Repository
public interface TaskItemRepository extends JpaRepository<TaskItems, Long>{

	public List<TaskItems> findAllByTaskId(Long taskId);

}
