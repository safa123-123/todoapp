package com.safa.springboot.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safa.springboot.webservice.model.TaskItems;
import com.safa.springboot.webservice.repository.TaskItemRepository;

@RestController
public class TaskItemController {
	
	@Autowired
	TaskItemRepository taskItemRepository;
	
	@GetMapping("/taskItems")
	public List<TaskItems> getTasks(@RequestParam(value = "taskId") Long taskItemId) {
		return taskItemRepository.findAllByTaskId(taskItemId);
	}
	
	@PostMapping("/taskItem")
	public ResponseEntity<?> addTaskItem(@RequestBody TaskItems taskitem) {
		taskItemRepository.save(taskitem);
		return ResponseEntity.ok("Task Item successfully saved!");
	}
	
	@DeleteMapping("/taskItem")
	public ResponseEntity<?> deleteTask(@RequestParam(value = "taskItemId") Long taskItemId) {
		TaskItems foundTaskItem = taskItemRepository.findById(taskItemId).get();
		taskItemRepository.delete(foundTaskItem);
		return ResponseEntity.ok("Task Item successfully deleted!");
	}

}
