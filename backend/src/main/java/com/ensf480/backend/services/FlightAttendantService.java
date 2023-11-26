package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.FlightAttendant;
import com.ensf480.backend.repositories.CrewRepository;
import com.ensf480.backend.repositories.FlightAttendantRepository;

@Service
public class FlightAttendantService {
  @Autowired
  private FlightAttendantRepository flightAttendantRepository;

  @Autowired
  private CrewRepository crewRepository;

  public List<FlightAttendant> getAllFlightAttendants() {
    return flightAttendantRepository.findAll();
  }

  public FlightAttendant createNewFlightAttendant(FlightAttendant newFlightAttendant) {
    long crewId = newFlightAttendant.getCrewId();
    if (!crewRepository.existsById(crewId)) {
      throw new RuntimeException("Crew with id " + crewId + " does not exist");
    }
    return flightAttendantRepository.save(newFlightAttendant);
  }
}
