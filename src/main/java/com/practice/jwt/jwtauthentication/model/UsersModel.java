package com.practice.jwt.jwtauthentication.model;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UsersModel {

  private static final ModelMapper mapper = new ModelMapper();

  static {
    mapper.createTypeMap(Users.class, UsersModel.class)
        .addMappings(m -> m.skip(UsersModel::setPassword));
  }

  private String username;
  private String password;
  private UserRole role;

  public static UsersModel from(Users user) {
    return mapper.map(user, UsersModel.class);
  }

  public Users toUsers(PasswordEncoder passwordEncoder) {
    Users user = mapper.map(this, Users.class);
    user.setPassword(passwordEncoder.encode(this.getPassword()));
    return user;
  }
}
