package com.practice.jwt.jwtauthentication.service;

import com.practice.jwt.jwtauthentication.model.Users;
import com.practice.jwt.jwtauthentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public Users getByUsername(String username) {
    return userRepository
        .findByUsername(username)
        .orElseThrow(
            () -> new UsernameNotFoundException("User not found with username: " + username));
  }

  @Transactional
  public Users save(Users user) {
    return userRepository.save(user);
  }
}
