package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.User;
import com.ensf480.backend.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> getPersons() {
    return userService.getAllUsers();
  }

  @PostMapping
  public User postPerson() {
    return userService.createNewUser();
  }
}