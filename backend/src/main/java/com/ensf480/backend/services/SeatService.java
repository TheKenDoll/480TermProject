package com.ensf480.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Seat;
import com.ensf480.backend.repositories.SeatRepository;

@Service
public class SeatService {
  @Autowired
  private SeatRepository seatRepository;

  public Seat updateSeat(long id, Seat seat) {
    if (!seatRepository.existsById(id)) {
      throw new RuntimeException("Seat with id " + id + " does not exist");
    }
    Seat existingSeat = seatRepository.findById(id).get();
    existingSeat.setAvailable(seat.getAvailable());
    return seatRepository.save(existingSeat);
  }
}
