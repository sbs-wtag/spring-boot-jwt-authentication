package com.practice.jwt.jwtauthentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HomeController {

  @GetMapping("/hello")
  public String hello() {
    return "Hello!";
  }

  @GetMapping("/helloAdmin")
  public String helloAdmin() {
    return "Hello Admin!";
  }

  @GetMapping("/helloOperator")
  public String helloOperator() {
    return "Hello Operator!";
  }

}
