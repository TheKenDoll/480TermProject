package com.ensf480.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Copilot;
import com.ensf480.backend.repositories.CopilotRepository;

@Service
public class CopilotService {
  @Autowired
  private CopilotRepository copilotRepository;

  public List<Copilot> getAllCopilots() {
    return copilotRepository.findAll();
  }

  public Copilot createNewCopilot(Copilot newCopilot) {
    return copilotRepository.save(newCopilot);
  }
}
