package com.practice.jwt.jwtauthentication.controller;

import com.practice.jwt.jwtauthentication.config.JwtTokenUtil;
import com.practice.jwt.jwtauthentication.model.JwtRequest;
import com.practice.jwt.jwtauthentication.model.JwtResponse;
import com.practice.jwt.jwtauthentication.model.Users;
import com.practice.jwt.jwtauthentication.model.UsersModel;
import com.practice.jwt.jwtauthentication.service.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class JwtAuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final JwtUserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  @PostMapping(value = "/authenticate")
  public JwtResponse createAuthenticationToken(@RequestBody JwtRequest request) {
    final UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
    authenticationManager.authenticate(authenticationToken);
    final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);
    return JwtResponse.of(token);
  }

  @PostMapping(value = "/register")
  public UsersModel saveUser(@RequestBody UsersModel model) {
    final Users user = model.toUsers(passwordEncoder);
    userDetailsService.save(user);
    return UsersModel.from(user);
  }
}
