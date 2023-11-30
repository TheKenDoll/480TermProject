package com.ensf480.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.Seat;
import com.ensf480.backend.services.SeatService;

@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {
  @Autowired
  private SeatService seatService;

  @PutMapping("/{id}")
  public ResponseEntity<?> updateSeat(@PathVariable("id") long id, @RequestBody Seat seat) {
    try {
      Seat updatedSeat = seatService.updateSeat(id, seat);
      return ResponseEntity.status(HttpStatus.OK).body(updatedSeat);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
