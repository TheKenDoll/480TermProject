package com.ensf480.backend.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Flight {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String number;
  private String destination;
  private String origin;
  private String departureTime;
  private String arrivalTime;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
  private Aircraft aircraft;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "crew_id", referencedColumnName = "id")
  private Crew crew;

  @Column(name = "airline_id")
  private long airlineId;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Flight(String number, String destination, String origin, String departureTime, String arrivalTime) {
    this.number = number;
    this.destination = destination;
    this.origin = origin;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
  }

  public Flight(String number, String destination, String origin, String departureTime, String arrivalTime,
      Aircraft aircraft, Crew crew, long airlineId) {
    this.number = number;
    this.destination = destination;
    this.origin = origin;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.aircraft = aircraft;
    this.crew = crew;
    this.airlineId = airlineId;
  }
}
