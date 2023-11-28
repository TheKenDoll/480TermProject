package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public void createNewFlight(Flight newFlight) {
    long airlineId = newFlight.getAirlineId();
    if (!airlineRepository.existsById(airlineId)) {
      throw new RuntimeException("Airline with id " + airlineId + " does not exist");
    }
    flightRepository.save(newFlight);
  }

  public List<Flight> getFlightByOrigin(String origin) {
    return flightRepository.findByOrigin(origin);
  }

  public List<Flight> getFlightByDestination(String destination) {
    return flightRepository.findByDestination(destination);
  }

  public void deleteFlightById(long flightId) {
    if (!flightRepository.existsById(flightId)) {
      throw new RuntimeException("Flight with id " + flightId + " does not exist");
    }
    flightRepository.deleteById(flightId);
  }
}
