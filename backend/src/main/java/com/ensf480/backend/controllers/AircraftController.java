package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.Aircraft;
import com.ensf480.backend.services.AircraftService;

@RestController
@RequestMapping("/api/v1/aircraft")
public class AircraftController {
  @Autowired
  private AircraftService aircraftService;

  @GetMapping
  public ResponseEntity<List<Aircraft>> getAllAircrafts() {
    try {
      List<Aircraft> aircrafts = aircraftService.getAllAircrafts();
      return ResponseEntity.ok(aircrafts);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping
  public ResponseEntity<Aircraft> postAircraft(@RequestBody Aircraft newAircraft) {
    try {
      Aircraft createdAircraft = aircraftService.createNewAircraft(newAircraft);
      return ResponseEntity.ok(createdAircraft);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

}
