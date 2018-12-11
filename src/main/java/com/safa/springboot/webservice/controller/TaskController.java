package com.safa.springboot.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.safa.springboot.webservice.model.Task;
import com.safa.springboot.webservice.repository.TaskRepository;

@RestController
public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	@GetMapping("/tasks")
	public List<Task> getTasks(@RequestParam(value = "userId") String userId) {
		return taskRepository.findAllByUserId(Long.valueOf(userId));
	}

	@PostMapping("/task")
	public ResponseEntity<?> addTask(@RequestBody Task task) {
		taskRepository.save(task);
		return ResponseEntity.ok("Task successfully saved!");

	}
	
	@DeleteMapping("/task")
	public ResponseEntity<?> deleteTask(@RequestParam(value = "taskId") Long taskId) {
		Task foundTask = taskRepository.findById(taskId).get();
		taskRepository.delete(foundTask);
		return ResponseEntity.ok("Task successfully deleted!");
	}

}
