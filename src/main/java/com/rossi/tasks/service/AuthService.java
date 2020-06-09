package com.rossi.tasks.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

  @Override
  public Long getUserId(String token) {
    DecodedJWT decodedJWT = JWT.decode(token.replace("Bearer ", ""));
    return decodedJWT.getClaim("user_id").asLong();
  }

  @Override
  public String getUsername(String token) {
    DecodedJWT decodedJWT = JWT.decode(token.replace("Bearer ", ""));
    return decodedJWT.getClaim("username").asString();
  }

}