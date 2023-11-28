package com.ensf480.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensf480.backend.models.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

  List<Flight> findByOrigin(String origin);

  List<Flight> findByDestination(String destination);

}
