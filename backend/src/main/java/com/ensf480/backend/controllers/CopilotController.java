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

import com.ensf480.backend.models.Copilot;
import com.ensf480.backend.services.CopilotService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/copilot")
public class CopilotController {
  @Autowired
  private CopilotService copilotService;

  @GetMapping
  public ResponseEntity<?> getAllCopilots() {
    try {
      List<Copilot> copilots = copilotService.getAllCopilots();
      return ResponseEntity.status(HttpStatus.OK).body(copilots);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> createNewCopilot(@RequestBody Copilot newCopilot) {
    try {
      copilotService.createNewCopilot(newCopilot);
      return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
