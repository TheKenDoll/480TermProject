package com.ensf480.backend.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.Client;
import com.ensf480.backend.services.ClientService;

@RestController
@RequestMapping("/api/v1/Client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping
  public ResponseEntity<List<Client>> getPersons() {
    return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
  }

  @PostMapping
  public Client postPerson() {
    return clientService.createNewClient();
  }

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody Client Client) {

    clientService.registerClient(Client);

    return new ResponseEntity<>("Client registered successfully", HttpStatus.CREATED);
  }

  // @PostMapping("/login")
  // public ResponseEntity<String> loginUser(
  //     @RequestParam("e--mail") String email,
  //     @RequestParam("password") String password,
  //     ModelMap modelMap) {

  //   boolean loginSuccessful = clientService.login(email, password);

  //   if (loginSuccessful) {
  //     return new ResponseEntity<>("Client logged in successfully", HttpStatus.OK);
  //   } else {
  //     modelMap.addAttribute("msg", "Invalid username or password. Please try again.");
  //     return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
  //   }
  // }

  @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> loginRequest, ModelMap modelMap) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        // Rest of your code...



        boolean loginSuccessful = clientService.login(email, password);

        if (loginSuccessful) {
          return new ResponseEntity<>("Client logged in successfully", HttpStatus.OK);
        } else {
          modelMap.addAttribute("msg", "Invalid username or password. Please try again.");
          return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }

}





//   @PostMapping("/login1")
//     public ResponseEntity<String> loginUser1(@RequestBody Map<String, String> loginRequest, ModelMap modelMap) {
//         String email = loginRequest.get("email");
//         String password = loginRequest.get("password");

//         // Rest of your code...



//         boolean loginSuccessful = clientService.login1(email, password);

//         if (loginSuccessful) {
//           return new ResponseEntity<>("Client logged in successfully", HttpStatus.OK);
//         } else {
//           modelMap.addAttribute("msg", "Invalid username or password. Please try again.");
//           return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
//         }

// }

}
