package com.practice.jwt.jwtauthentication.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
  ADMIN,
  OPERATOR;

  @Override
  public String getAuthority() {
    return this.name();
  }
}
