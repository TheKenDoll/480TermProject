package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.Copilot;
import com.ensf480.backend.services.CopilotService;

@RestController
@RequestMapping("/api/v1/copilot")
public class CopilotController {
  @Autowired
  private CopilotService copilotService;

  @GetMapping
  public ResponseEntity<List<Copilot>> getAllCopilots() {
    try {
      List<Copilot> copilots = copilotService.getAllCopilots();
      return new ResponseEntity<>(copilots, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Copilot> createNewCopilot(Copilot newCopilot) {
    try {
      Copilot createdCopilot = copilotService.createNewCopilot(newCopilot);
      return new ResponseEntity<>(createdCopilot, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
