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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.Airline;
import com.ensf480.backend.services.AirlineService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/airline")
public class AirlineController {

  @Autowired
  private AirlineService airlineService;

  @GetMapping
  public ResponseEntity<?> getAllAirlines() {
    try {
      List<Airline> airlines = airlineService.getAllAirlines();
      return ResponseEntity.status(HttpStatus.OK).body(airlines);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get all airlines.");
    }
  }

  @PostMapping
  public ResponseEntity<?> postAirline(@RequestBody Airline newAirline) {
    try {
      airlineService.createNewAirline(newAirline);
      return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create new airline.");
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getAirlineByName(@PathVariable("id") long id) {
    try {
      Airline airline = airlineService.getAirlineById(id);
      return ResponseEntity.status(HttpStatus.OK).body(airline);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get airline by id.");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteAirline(@PathVariable("id") long airlineId) {
    try {
      airlineService.deleteAirlineById(airlineId);
      return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete airline by id.");
    }
  }

}
