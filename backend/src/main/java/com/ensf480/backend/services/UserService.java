package com.ensf480.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ensf480.backend.exception.UserAlreadyExistsException;
import com.ensf480.backend.models.User;
import com.ensf480.backend.repositories.UserRepository;
import java.util.List;

@Service
public class UserService  {


  private final static String USER_NOT_FOUUND = "user with email %s not found";
  @Autowired
  private UserRepository userRepository;

  private SecurityService securityService;

  //private BCryptPasswordEncoder bCryptPasswordEncoder;



  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User createNewUser() {

    return null;
    //return userRepository.save(new User("John", "Doe", "1234 Main St", "axel@mail.com", "password", "admin"));
  }


  /*public User registerUser(@ModelAttribute("user") User user){

    return userRepository.save(user);






  }*/



  public void registerUser(User user){
    validateuserForRegistration(user);

    boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

    if(userExists){

      throw new UserAlreadyExistsException("User with this email already exits");

    }

    // String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());


    // user.setPassword(encodedPassword);



    userRepository.save(user);

  }

    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        //boolean loginResponse = securityService.login(email, password);

        //return loginResponse;

        return user.getPassword().equals(password);
    }

  private void validateuserForRegistration(User user){
    if(user == null){
      throw new IllegalArgumentException("User cannot be null");

    }
    if (user.getFirstName() == null || user.getFirstName().isEmpty()){
      throw new IllegalArgumentException("First name is required ");
    }

    if (user.getLastName() == null | user.getLastName().isEmpty()){
      throw new IllegalArgumentException("Last name is required");

    }
    if(user.getAddress()== null | user.getAddress().isEmpty()){
      throw new IllegalArgumentException("Address is required");
    }
    if(user.getEmail() == null | user.getEmail().isEmpty()){
      throw new IllegalArgumentException("E-mail is required");
    }

    if(user.getPassword() == null | user.getPassword().isEmpty()){
      throw new IllegalArgumentException("Password is required");
    }

  }



}