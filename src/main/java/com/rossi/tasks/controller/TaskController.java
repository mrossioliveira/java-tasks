package com.rossi.tasks.controller;

import java.util.List;

import com.rossi.tasks.model.Task;
import com.rossi.tasks.service.IAuthService;
import com.rossi.tasks.service.ITaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  Logger logger = LoggerFactory.getLogger(TaskController.class);

  @Autowired
  IAuthService authService;

  @Autowired
  ITaskService taskService;

  @ResponseBody
  @GetMapping("/tasks")
  public List<Task> getTasks(@RequestHeader("Authorization") String authorization) {
    return this.taskService.findAll(this.authService.getUserId(authorization));
  }

  @ResponseBody
  @GetMapping("/tasks/important")
  public List<Task> getImportantTasks(@RequestHeader("Authorization") String authorization) {
    return this.taskService.findAllImportant(this.authService.getUserId(authorization));
  }

}