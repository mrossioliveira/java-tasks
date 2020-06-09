package com.rossi.tasks.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TasksMVCConfig implements WebMvcConfigurer {

  @Autowired
  private TasksRequestInterceptor tasksRequestInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(tasksRequestInterceptor).addPathPatterns(Arrays.asList("/tasks/**", "/lists/**"));
  }

}