package com.rossi.tasks.advices;

import com.rossi.tasks.exceptions.TaskListNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TaskListNotFoundAdvice {

  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(TaskListNotFoundException.class)
  public String handleTaskListNotFound(TaskListNotFoundException ex) {
    return ex.getMessage();
  }

}