package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Aircraft;
import com.ensf480.backend.models.Airline;
import com.ensf480.backend.repositories.AircraftRepository;
import com.ensf480.backend.repositories.AirlineRepository;

@Service
public class AircraftService {

  @Autowired
  private AircraftRepository aircraftRepository;

  @Autowired
  private AirlineRepository airlineRepository;

  public List<Aircraft> getAllAircrafts() {
    return aircraftRepository.findAll();
  }

  public Aircraft createNewAircraft(Aircraft newAircraft) {
    long airlineId = newAircraft.getAirlineId();
    Airline airline = airlineRepository.findById(airlineId).get();
    if (airline == null) {
      throw new RuntimeException("Airline not found");
    }
    return aircraftRepository.save(newAircraft);
  }

}
