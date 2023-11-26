package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.Pilot;
import com.ensf480.backend.services.PilotService;

@RestController
@RequestMapping("/api/v1/pilot")
public class PilotController {

  @Autowired
  private PilotService pilotService;

  @GetMapping
  public ResponseEntity<List<Pilot>> getAllPilots() {
    try {
      List<Pilot> pilots = pilotService.getAllPilots();
      return new ResponseEntity<>(pilots, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Pilot> createNewPilot(Pilot newPilot) {
    try {
      Pilot createdPilot = pilotService.createNewPilot(newPilot);
      return new ResponseEntity<>(createdPilot, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
