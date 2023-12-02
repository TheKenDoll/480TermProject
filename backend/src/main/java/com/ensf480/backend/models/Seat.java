package com.ensf480.backend.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String seatNumber;
  private double price;
  private Boolean available;
  private String seatClass;

  @Column(name = "aircraft_id")
  private long aircraftId;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Seat(
      boolean available) {
    this.available = available;
  }

  public Seat(
      String seatNumber,
      double price,
      boolean available,
      String seatClass,
      long aircraftId) {
    this.seatNumber = seatNumber;
    this.price = price;
    this.available = available;
    this.aircraftId = aircraftId;
  }
}
