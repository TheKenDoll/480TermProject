package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.User;
import com.ensf480.backend.repositories.UserRepository;
import com.ensf480.backend.services.SecurityService;
import com.ensf480.backend.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {




  @Autowired
  private UserService userService;
  private UserRepository userRepository;
  



  @GetMapping
  public ResponseEntity<List<User>> getPersons() {
    return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
  }





  @PostMapping
  public User postPerson() {
    return userService.createNewUser();
  }







  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@ModelAttribute("user") User user){

    userService.registerUser(user);

    return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);









  }



  @PostMapping("/login")
  public ResponseEntity<String> loginUser(
          @RequestParam("email") String email,
          @RequestParam("password") String password,
          ModelMap modelMap) {

      boolean loginSuccessful = userService.login(email, password);

      if (loginSuccessful) {
          return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
      } else {
          modelMap.addAttribute("msg", "Invalid username or password. Please try again.");
          return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
      }
  }


}
