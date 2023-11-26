package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.FlightAttendant;
import com.ensf480.backend.services.FlightAttendantService;

@RestController
@RequestMapping("/api/v1/flight-attendant")
public class FlightAttendantController {

  @Autowired
  private FlightAttendantService flightAttendantService;

  @GetMapping
  public ResponseEntity<List<FlightAttendant>> getAllFlightAttendants() {
    try {
      List<FlightAttendant> flightAttendants = flightAttendantService.getAllFlightAttendants();
      return new ResponseEntity<>(flightAttendants, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<FlightAttendant> createNewFlightAttendant(@RequestBody FlightAttendant newFlightAttendant) {
    try {
      FlightAttendant createdFlightAttendant = flightAttendantService.createNewFlightAttendant(newFlightAttendant);
      return new ResponseEntity<>(createdFlightAttendant, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
