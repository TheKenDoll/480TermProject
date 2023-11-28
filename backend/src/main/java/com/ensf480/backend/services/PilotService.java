package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Pilot;

import com.ensf480.backend.repositories.PilotRepository;

@Service
public class PilotService {
  @Autowired
  private PilotRepository pilotRepository;

  public List<Pilot> getAllPilots() {
    return pilotRepository.findAll();
  }

  public Pilot createNewPilot(Pilot newPilot) {
    return pilotRepository.save(newPilot);
  }
}
