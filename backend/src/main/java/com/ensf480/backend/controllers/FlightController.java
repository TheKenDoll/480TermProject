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

import com.ensf480.backend.models.Flight;
import com.ensf480.backend.services.FlightService;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {

  @Autowired
  private FlightService flightService;

  @GetMapping
  public ResponseEntity<List<Flight>> getFlight() {
    try {
      List<Flight> flights = flightService.getAllFlights();
      return new ResponseEntity<>(flights, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Flight> postFlight(@RequestBody Flight newFlight) {
    try {
      Flight createdFlight = flightService.createNewFlight(newFlight);
      return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
