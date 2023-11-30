// package com.ensf480.backend.services;

// import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.ensf480.backend.models.Client;
// import com.ensf480.backend.repositories.ClientRepository;

// @Service
// public class ClientServiceDetailsImpl implements UserDetailsService {
//     @Autowired
//     private ClientRepository clientRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//         Client client = clientRepository.findByEmail(username)
//                 .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

//         return new org.springframework.security.core.userdetails.User(client.getEmail(), client.getPassword(),
//                 client.getRoles());
//     }

// }
