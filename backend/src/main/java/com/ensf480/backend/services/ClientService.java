package com.ensf480.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Client;
import com.ensf480.backend.repositories.ClientRepository;
import java.util.List;

@Service
public class ClientService {
  @Autowired
  private ClientRepository userRepository;

  public List<Client> getAllClients() {
    return userRepository.findAll();
  }

  public Client createNewClient(Client client) {
    return userRepository.save(client);
  }
}