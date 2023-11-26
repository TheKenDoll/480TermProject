package com.ensf480.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensf480.backend.models.Copilot;

@Repository
public interface CopilotRepository extends JpaRepository<Copilot, Long> {

}
