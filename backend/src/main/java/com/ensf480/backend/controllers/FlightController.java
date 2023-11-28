package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<HttpStatus> postFlight(@RequestBody Flight newFlight) {
    try {
      flightService.createNewFlight(newFlight);
      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/origin/{origin}")
  public ResponseEntity<List<Flight>> getFlightByOrigin(@PathVariable("origin") String origin) {
    try {
      List<Flight> flights = flightService.getFlightByOrigin(origin);
      return new ResponseEntity<>(flights, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/destination/{destination}")
  public ResponseEntity<List<Flight>> getFlightByDestination(@PathVariable("destination") String destination) {
    try {
      List<Flight> flights = flightService.getFlightByDestination(destination);
      return new ResponseEntity<>(flights, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteFlight(@PathVariable("id") long flightId) {
    try {
      flightService.deleteFlightById(flightId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
