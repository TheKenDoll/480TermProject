package com.ensf480.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ensf480.backend.exception.UserAlreadyExistsException;
import com.ensf480.backend.models.Client;
import com.ensf480.backend.repositories.ClientRepository;
import java.util.List;

@Service
public class ClientService {

  private final static String USER_NOT_FOUUND = "client with email %s not found";
  @Autowired
  private ClientRepository clientRepository;

  private SecurityService securityService;

  // private BCryptPasswordEncoder bCryptPasswordEncoder;

  public List<Client> getAllClients() {
    return clientRepository.findAll();
  }

  public Client createNewClient() {

    return null;
    // return userRepository.save(new client("John", "Doe", "1234 Main St",
    // "axel@mail.com", "password", "admin"));
  }

  /*
   * public client registerUser(@ModelAttribute("client") client client){
   * 
   * return userRepository.save(client);
   * 
   * 
   * 
   * 
   * 
   * 
   * }
   */

  public void registerClient(Client client) {
    validateClientForRegistration(client);

    boolean clientExists = clientRepository.findByEmail(client.getEmail()).isPresent();

    if (clientExists) {

      throw new UserAlreadyExistsException("client with this email already exits");

    }

    // String encodedPassword = bCryptPasswordEncoder.encode(client.getPassword());

    // client.setPassword(encodedPassword);

    clientRepository.save(client);

  }

  public boolean login(String email, String password) {
    Client client = clientRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("client not found with email: " + email));

    // boolean loginResponse = securityService.login(email, password);

    // return loginResponse;

    return client.getPassword().equals(password);
  }

  private void validateClientForRegistration(Client client) {
    if (client == null) {
      throw new IllegalArgumentException("client cannot be null");

    }
    if (client.getFirstName() == null || client.getFirstName().isEmpty()) {
      throw new IllegalArgumentException("First name is required ");
    }

    if (client.getLastName() == null | client.getLastName().isEmpty()) {
      throw new IllegalArgumentException("Last name is required");

    }
    if (client.getAddress() == null | client.getAddress().isEmpty()) {
      throw new IllegalArgumentException("Address is required");
    }
    if (client.getEmail() == null | client.getEmail().isEmpty()) {
      throw new IllegalArgumentException("E-mail is required");
    }

    if (client.getPassword() == null | client.getPassword().isEmpty()) {
      throw new IllegalArgumentException("Password is required");
    }

  }

}