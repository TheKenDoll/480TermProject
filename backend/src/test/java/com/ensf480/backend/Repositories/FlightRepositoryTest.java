package com.ensf480.backend.Repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ensf480.backend.models.Airline;
import com.ensf480.backend.models.Flight;
import com.ensf480.backend.repositories.AirlineRepository;
import com.ensf480.backend.repositories.FlightRepository;

@DataJpaTest
public class FlightRepositoryTest {

  @Autowired
  private FlightRepository flightRepository;

  @Autowired
  private AirlineRepository airlineRepository;

  @Test
  public void postFlightTest() {
    Airline newAirline = new Airline("Aeromexico", "Mexico");
    Airline createdAirline = airlineRepository.save(newAirline);
    Flight newFlight = new Flight("123", "destination", "origin", "departureTime", "arrivalTime",
        createdAirline.getId());
    Flight createdFlight = flightRepository.save(newFlight);
    Flight anotherFlight = flightRepository.findById(1L).get();
    System.out.println(airlineRepository.findById(2L).get());
    assert (anotherFlight.getId() == createdFlight.getId());
    assert (anotherFlight.getDestination().equals(createdFlight.getDestination()));
    assert (anotherFlight.getOrigin().equals(createdFlight.getOrigin()));
    assert (anotherFlight.getDepartureTime().equals(createdFlight.getDepartureTime()));
    assert (anotherFlight.getArrivalTime().equals(createdFlight.getArrivalTime()));
    assert (anotherFlight.getAirlineId() == createdFlight.getAirlineId());
  }

}
