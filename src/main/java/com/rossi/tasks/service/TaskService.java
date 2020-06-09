package com.rossi.tasks.service;

import java.util.List;

import com.rossi.tasks.model.Task;
import com.rossi.tasks.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements ITaskService {

  @Autowired
  TaskRepository taskRepository;

  @Override
  public List<Task> findAll(Long userId) {
    return this.taskRepository.findByUserIdOrderByCreatedAt(userId);
  }

  @Override
  public List<Task> findAllImportant(Long userId) {
    return this.taskRepository.findByUserIdAndImportant(userId, true);
  }

  @Override
  public List<Task> findByUserIdAndListId(Long listId, Long userId) {
    return this.taskRepository.findByUserIdAndListId(userId, listId);
  }

}