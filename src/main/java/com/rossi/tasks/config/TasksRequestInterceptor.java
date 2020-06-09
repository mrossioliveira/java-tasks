package com.rossi.tasks.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TasksRequestInterceptor implements HandlerInterceptor {

  private final String AUTH_HEADER = "Authorization";
  // FIXME: Remove hardcoded secret
  private final String SECRET = "2easy2forget";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    // ignore pre-flight requests
    if (request.getMethod().equals("OPTIONS")) {
      return true;
    }

    // any other type should provide a token
    if (request.getHeader(AUTH_HEADER) == null) {
      throw new JWTVerificationException("Authorization token not provided");
    }

    // validate the token
    DecodedJWT decodedJWT = JWT.decode(request.getHeader(AUTH_HEADER).replace("Bearer ", ""));
    Verification verifier = JWT.require(Algorithm.HMAC256(SECRET));
    verifier.build().verify(decodedJWT.getToken());
    return true;
  }

}