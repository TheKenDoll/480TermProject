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

import com.ensf480.backend.models.Pilot;
import com.ensf480.backend.services.PilotService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/pilot")
public class PilotController {

  @Autowired
  private PilotService pilotService;

  @GetMapping
  public ResponseEntity<?> getAllPilots() {
    try {
      List<Pilot> pilots = pilotService.getAllPilots();
      return ResponseEntity.status(HttpStatus.OK).body(pilots);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> createNewPilot(@RequestBody Pilot newPilot) {
    try {
      pilotService.createNewPilot(newPilot);
      return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

}
