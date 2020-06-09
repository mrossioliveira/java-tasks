package com.rossi.tasks.exceptions;

public class TaskListNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public TaskListNotFoundException(Long id) {
    super("Could not find list with ID " + id);
  }

}