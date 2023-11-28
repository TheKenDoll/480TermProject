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

import com.ensf480.backend.models.Airline;
import com.ensf480.backend.services.AirlineService;

@RestController
@RequestMapping("/api/v1/airline")
public class AirlineController {

  @Autowired
  private AirlineService airlineService;

  @GetMapping
  public ResponseEntity<List<Airline>> getAllAirlines() {
    try {
      List<Airline> airlines = airlineService.getAllAirlines();
      return new ResponseEntity<>(airlines, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<HttpStatus> postAirline(@RequestBody Airline newAirline) {
    try {
      airlineService.createNewAirline(newAirline);
      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteAirline(@PathVariable("id") long airlineId) {
    try {
      airlineService.deleteAirlineById(airlineId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
