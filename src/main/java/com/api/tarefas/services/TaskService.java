package com.api.tarefas.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.tarefas.models.TaskModel;
import com.api.tarefas.repositories.TaskRepository;

@Service
public class TaskService {

	final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Transactional
	public TaskModel save(TaskModel taskModel) {
		return taskRepository.save(taskModel);
	}

	public List<TaskModel> findAll() {
		return taskRepository.findAll();
	}

	public Optional<TaskModel> findById(UUID id) {
		return taskRepository.findById(id);
	}

	public void delete(TaskModel taskModel) {
		taskRepository.delete(taskModel);
	}
	
}
