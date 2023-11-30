package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.Flight;
import com.ensf480.backend.services.FlightService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {

  @Autowired
  private FlightService flightService;

  @GetMapping
  public ResponseEntity<?> getFlight() {
    try {
      List<Flight> flights = flightService.getAllFlights();
      return ResponseEntity.status(HttpStatus.OK).body(flights);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> postFlight(@RequestBody Flight newFlight) {
    try {
      flightService.createNewFlight(newFlight);
      return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateFlight(@PathVariable("id") long flightId, @RequestBody Flight flight) {
    try {
      Flight updatedFlight = flightService.updateFlight(flightId, flight);
      return ResponseEntity.status(HttpStatus.OK).body(updatedFlight);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteFlight(@PathVariable("id") long flightId) {
    try {
      flightService.deleteFlightById(flightId);
      return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/origin/{origin}")
  public ResponseEntity<?> getFlightByOrigin(@PathVariable("origin") String origin) {
    try {
      List<Flight> flights = flightService.getFlightByOrigin(origin);
      return ResponseEntity.status(HttpStatus.OK).body(flights);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/destination/{destination}")
  public ResponseEntity<?> getFlightByDestination(@PathVariable("destination") String destination) {
    try {
      List<Flight> flights = flightService.getFlightByDestination(destination);
      return ResponseEntity.status(HttpStatus.OK).body(flights);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/origin/{origin}/destination/{destination}/date/{date}")
  public ResponseEntity<?> getFlightByOriginDestinationDate(@PathVariable("origin") String origin,
      @PathVariable("destination") String destination, @PathVariable("date") String date) {
    try {
      List<Flight> flights = flightService.getFlightByOriginDestinationDate(destination, origin, date);
      return ResponseEntity.status(HttpStatus.OK).body(flights);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(e.getMessage());
    }
  }
}
