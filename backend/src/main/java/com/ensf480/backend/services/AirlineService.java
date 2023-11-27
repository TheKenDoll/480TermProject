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

  public Airline createNewAirline(Airline newAirline) {
    return airlineRepository.save(newAirline);
  }
}
