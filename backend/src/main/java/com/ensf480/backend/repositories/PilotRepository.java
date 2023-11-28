package com.ensf480.backend.repositories;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensf480.backend.models.Pilot;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Long> {

}
