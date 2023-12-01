package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.FlightAttendant;
import com.ensf480.backend.services.FlightAttendantService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/flight-attendant")
public class FlightAttendantController {

  @Autowired
  private FlightAttendantService flightAttendantService;

  @GetMapping
  public ResponseEntity<?> getAllFlightAttendants() {
    try {
      List<FlightAttendant> flightAttendants = flightAttendantService.getAllFlightAttendants();
      return ResponseEntity.status(HttpStatus.OK).body(flightAttendants);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> createNewFlightAttendant(@RequestBody FlightAttendant newFlightAttendant) {
    try {
      flightAttendantService.createNewFlightAttendant(newFlightAttendant);
      return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

}
