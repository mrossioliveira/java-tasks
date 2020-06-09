package com.rossi.tasks.repository;

import java.util.List;

import com.rossi.tasks.model.TaskList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<TaskList, Long> {

  public List<TaskList> findByUserId(Long userId);

}