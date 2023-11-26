package com.ensf480.backend.Repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ensf480.backend.models.Airline;
import com.ensf480.backend.repositories.AirlineRepository;

@DataJpaTest
public class AirlineRepositoryTest {

  @Autowired
  private AirlineRepository airlineRepository;

  @Test
  public void postAirlineTest() {
    Airline newAirline = new Airline("Aeromexico", "Mexico");
    Airline createdAirline = airlineRepository.save(newAirline);
    Airline anotherAirline = airlineRepository.findById(1L).get();
    assert (anotherAirline.getId() == createdAirline.getId());
    assert (anotherAirline.getName().equals(createdAirline.getName()));
    assert (anotherAirline.getCountry().equals(createdAirline.getCountry()));
  }

}
