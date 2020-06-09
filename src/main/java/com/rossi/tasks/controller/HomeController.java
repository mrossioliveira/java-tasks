package com.rossi.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rossi.tasks.service.ITaskService;

@RestController()
@CrossOrigin()
public class HomeController {

  @Autowired
  ITaskService taskService;

  @GetMapping("/")
  public String home() {
    return "Spring Boot Up";
  }

}