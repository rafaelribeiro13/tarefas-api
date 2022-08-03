package com.api.tarefas.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tarefas.dtos.TaskDto;
import com.api.tarefas.models.TaskModel;
import com.api.tarefas.services.TaskService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/tasks")
public class TaskController {
    
	final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> saveTask(@RequestBody @Valid TaskDto taskDto) {
		var taskModel = new TaskModel();
		BeanUtils.copyProperties(taskDto, taskModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(taskModel));
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<List<TaskModel>> getAllTasks() {
		return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
	}
	
	@GetMapping("/get-one/{id}")
	public ResponseEntity<Object> getOneTask(@PathVariable(value = "id") UUID id) {
		Optional<TaskModel> taskModelOptional = taskService.findById(id);
		if (!taskModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") UUID id) {
		Optional<TaskModel> taskModelOptional = taskService.findById(id);
		if (!taskModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found!");
		}
		
		taskService.delete(taskModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Task deleted sucessfully!");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateTask(@PathVariable(value = "id") UUID id, 
						@RequestBody @Valid TaskDto taskDto) {
	
		Optional<TaskModel> taskModelOptional = taskService.findById(id);
		if (!taskModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found!");
		}
		
		var taskModel = new TaskModel();
		BeanUtils.copyProperties(taskDto, taskModel);
		taskModel.setId(taskModelOptional.get().getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(taskService.save(taskModel));
	}
	
}
