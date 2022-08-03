package com.api.tarefas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.tarefas.models.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, UUID>{

}
