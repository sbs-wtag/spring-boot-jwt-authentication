package com.practice.jwt.jwtauthentication.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JwtResponse {

  private final String jwtToken;

  public static JwtResponse of(String jwtToken) {
    return new JwtResponse(jwtToken);
  }
}