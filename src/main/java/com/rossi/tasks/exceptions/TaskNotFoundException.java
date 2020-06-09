package com.rossi.tasks.exceptions;

public class TaskNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public TaskNotFoundException(Long id) {
    super("Could not find task with ID " + id);
  }

}