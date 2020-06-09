package com.rossi.tasks.service;

public interface IAuthService {
  public Long getUserId(String token);

  public String getUsername(String token);
}