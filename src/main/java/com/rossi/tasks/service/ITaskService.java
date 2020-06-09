package com.rossi.tasks.service;

import java.util.List;

import com.rossi.tasks.model.Task;

public interface ITaskService {
  public List<Task> findAll(Long userId);

  public List<Task> findAllImportant(Long userId);

  public List<Task> findByUserIdAndListId(Long listId, Long userId);
}