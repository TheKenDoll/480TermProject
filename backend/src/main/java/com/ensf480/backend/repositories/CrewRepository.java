package com.ensf480.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensf480.backend.models.Crew;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {

}
