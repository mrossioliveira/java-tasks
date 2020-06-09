package com.rossi.tasks.service;

import java.util.List;

import com.rossi.tasks.model.TaskList;

public interface IListService {

  public List<TaskList> findByUserId(Long userId);

  public TaskList findById(Long id);

}