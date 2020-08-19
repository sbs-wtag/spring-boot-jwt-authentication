package com.practice.jwt.jwtauthentication.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class JwtRequest {

  private String username;
  private String password;
}