package com.rossi.tasks.repository;

import java.util.List;

import com.rossi.tasks.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  public List<Task> findByUserIdOrderByCreatedAt(Long userId);

  public List<Task> findByUserIdAndImportant(Long userId, boolean important);

  public List<Task> findByUserIdAndListId(Long userId, Long listId);
}