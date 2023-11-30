package com.ensf480.backend.services;

import java.util.List;
import java.util.ArrayList;

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

  public List<Flight> getFlightByOriginDestinationDate(String destination, String origin, String departureTime) {
    System.out.println("getFlightByOriginDestinationDate");
    List<Flight> filteredFlights = new ArrayList<Flight>();
    List<Flight> flights = flightRepository.findAll();
    for (Flight flight : flights) {
      if (flight.getDestination().equals(destination) && flight.getOrigin().equals(origin)
          && flight.getDepartureTime().equals(departureTime)) {
        filteredFlights.add(flight);
      }
    }
    return filteredFlights;
  }

  public Flight updateFlight(long id, Flight flight) {
    if (!flightRepository.existsById(id)) {
      throw new RuntimeException("Flight with id " + id + " does not exist");
    }
    Flight existingFlight = flightRepository.findById(id).get();
    existingFlight.setNumber(flight.getNumber());
    existingFlight.setDestination(flight.getDestination());
    existingFlight.setOrigin(flight.getOrigin());
    existingFlight.setDepartureTime(flight.getDepartureTime());
    existingFlight.setArrivalTime(flight.getArrivalTime());
    existingFlight.setAircraft(flight.getAircraft());
    return flightRepository.save(existingFlight);
  }

  public void deleteFlightById(long flightId) {
    if (!flightRepository.existsById(flightId)) {
      throw new RuntimeException("Flight with id " + flightId + " does not exist");
    }
    flightRepository.deleteById(flightId);
  }
}
