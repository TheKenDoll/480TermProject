package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.Crew;
import com.ensf480.backend.services.CrewService;

@RestController
@RequestMapping("/api/v1/crew")
public class CrewController {
  @Autowired
  private CrewService crewService;

  @GetMapping
  public ResponseEntity<List<Crew>> getAllCrew() {
    try {
      List<Crew> crew = crewService.getAllCrew();
      return new ResponseEntity<>(crew, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Crew> postCrew(Crew newCrew) {
    try {
      Crew createdCrew = crewService.createNewCrew(newCrew);
      return new ResponseEntity<>(createdCrew, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
