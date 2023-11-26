package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Copilot;
import com.ensf480.backend.models.Crew;
import com.ensf480.backend.repositories.CopilotRepository;

import com.ensf480.backend.repositories.CrewRepository;

@Service
public class CopilotService {
  @Autowired
  private CopilotRepository copilotRepository;

  @Autowired
  private CrewRepository crewRepository;

  public List<Copilot> getAllCopilots() {
    return copilotRepository.findAll();
  }

  public Copilot createNewCopilot(Copilot newCopilot) {
    Crew crew = newCopilot.getCrew();
    if (!crewRepository.existsById(crew.getId())) {
      throw new RuntimeException("Crew with id " + crew + " does not exist");
    }
    return copilotRepository.save(newCopilot);
  }
}
