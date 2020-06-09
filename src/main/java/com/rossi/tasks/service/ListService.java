package com.rossi.tasks.service;

import java.util.List;
import java.util.Optional;

import com.rossi.tasks.exceptions.TaskListNotFoundException;
import com.rossi.tasks.model.TaskList;
import com.rossi.tasks.repository.ListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService implements IListService {

  @Autowired
  ListRepository listRepository;

  @Override
  public List<TaskList> findByUserId(Long userId) {
    return this.listRepository.findByUserId(userId);
  }

  @Override
  public TaskList findById(Long id) {
    Optional<TaskList> list = this.listRepository.findById(id);
    return list.orElseThrow(() -> new TaskListNotFoundException(id));
  }

}