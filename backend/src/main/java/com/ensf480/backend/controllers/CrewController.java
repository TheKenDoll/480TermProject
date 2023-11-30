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

import com.ensf480.backend.models.Crew;
import com.ensf480.backend.services.CrewService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/crew")
public class CrewController {
  @Autowired
  private CrewService crewService;

  @GetMapping
  public ResponseEntity<?> getAllCrew() {
    try {
      List<Crew> crew = crewService.getAllCrew();
      return ResponseEntity.status(HttpStatus.OK).body(crew);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> postCrew(@RequestBody Crew newCrew) {
    try {
      System.out.println("newCrew: " + newCrew);
      Crew createdCrew = crewService.createNewCrew(newCrew);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdCrew);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCrew(@PathVariable("id") long id) {
    try {
      crewService.deleteCrewById(id);
      return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
