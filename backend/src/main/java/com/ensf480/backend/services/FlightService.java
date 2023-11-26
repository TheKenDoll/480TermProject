package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Airline;
import com.ensf480.backend.models.Flight;
import com.ensf480.backend.repositories.AirlineRepository;
import com.ensf480.backend.repositories.FlightRepository;

@Service
public class FlightService {
  @Autowired
  private FlightRepository flightRepository;

  @Autowired
  private AirlineRepository airlineRepository;

  public List<Flight> getAllFlights() {
    return flightRepository.findAll();
  }

  public Flight createNewFlight(Flight newFlight) {
    long airlineId = newFlight.getAirlineId();
    Airline airline = airlineRepository.findById(airlineId).get();
    if (airline == null) {
      throw new RuntimeException("Airline not found");
    }
    return flightRepository.save(newFlight);
  }
}
