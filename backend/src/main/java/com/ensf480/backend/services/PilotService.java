package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Crew;
import com.ensf480.backend.models.Pilot;

import com.ensf480.backend.repositories.CrewRepository;
import com.ensf480.backend.repositories.PilotRepository;

@Service
public class PilotService {
  @Autowired
  private PilotRepository pilotRepository;

  @Autowired
  private CrewRepository crewRepository;

  public List<Pilot> getAllPilots() {
    return pilotRepository.findAll();
  }

  public Pilot createNewPilot(Pilot newPilot) {
    Crew crew = newPilot.getCrew();
    if (!crewRepository.existsById(crew.getId())) {
      throw new RuntimeException("Crew with id " + crew + " does not exist");
    }
    return pilotRepository.save(newPilot);
  }
}
