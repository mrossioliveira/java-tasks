package com.rossi.tasks.controller;

import java.util.List;

import com.rossi.tasks.model.Task;
import com.rossi.tasks.model.TaskList;
import com.rossi.tasks.service.AuthService;
import com.rossi.tasks.service.IListService;
import com.rossi.tasks.service.ITaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

  @Autowired
  AuthService authService;

  @Autowired
  IListService listService;

  @Autowired
  ITaskService taskService;

  @ResponseBody
  @GetMapping("/lists")
  public List<TaskList> getLists(@RequestHeader("Authorization") String authorization) {
    return this.listService.findByUserId(this.authService.getUserId(authorization));
  }

  @ResponseBody
  @GetMapping("/lists/{id}")
  public TaskList getListById(@PathVariable("id") Long id, @RequestHeader("Authorization") String authorization) {
    return this.listService.findById(id);
  }

  @GetMapping("lists/{id}/tasks")
  public List<Task> getTasksByList(@PathVariable("id") Long id, @RequestHeader("Authorization") String authorization) {
    return this.taskService.findByUserIdAndListId(id, this.authService.getUserId(authorization));
  }

}