package com.ensf480.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.User;
import com.ensf480.backend.repositories.UserRepository;
import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User createNewUser() {
    return userRepository.save(new User("John", "Doe", "1234 Main St", "axel@mail.com", "password", "admin"));
  }
}