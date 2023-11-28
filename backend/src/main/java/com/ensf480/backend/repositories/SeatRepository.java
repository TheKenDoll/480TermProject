package com.ensf480.backend.repositories;

import com.ensf480.backend.models.Seat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
