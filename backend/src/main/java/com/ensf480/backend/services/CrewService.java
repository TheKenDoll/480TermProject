package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Crew;
import com.ensf480.backend.repositories.AirlineRepository;
import com.ensf480.backend.repositories.CrewRepository;

@Service
public class CrewService {
  @Autowired
  private CrewRepository crewRepository;

  @Autowired
  private AirlineRepository airlineRepository;

  public List<Crew> getAllCrew() {
    return crewRepository.findAll();
  }

  public Crew createNewCrew(Crew newCrew) {
    long airlineId = newCrew.getAirlineId();

    if (!airlineRepository.existsById(airlineId)) {
      throw new IllegalArgumentException("Airline with id " + airlineId + " does not exist");
    }
    return crewRepository.save(newCrew);
  }

  public void deleteCrewById(long id) {
    if (!crewRepository.existsById(id)) {
      throw new IllegalArgumentException("Crew with id " + id + " does not exist");
    }
    crewRepository.deleteById(id);
  }
}
