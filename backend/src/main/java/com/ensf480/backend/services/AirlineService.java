package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Airline;
import com.ensf480.backend.repositories.AirlineRepository;

@Service
public class AirlineService {

  @Autowired
  private AirlineRepository airlineRepository;

  public List<Airline> getAllAirlines() {
    return airlineRepository.findAll();
  }

  public void createNewAirline(Airline newAirline) {
    airlineRepository.save(newAirline);
  }

  public void deleteAirlineById(long airlineId) {
    if (!airlineRepository.existsById(airlineId)) {
      throw new RuntimeException("Airline with id " + airlineId + " does not exist");
    }
    airlineRepository.deleteById(airlineId);
  }
}
