package com.practice.jwt.jwtauthentication.service;

import com.practice.jwt.jwtauthentication.model.Users;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = userService.getByUsername(username);
    return new User(user.getUsername(), user.getPassword(),
        Collections.singletonList(user.getRole()));
  }

  public void save(Users user) {
    userService.save(user);
  }
}
