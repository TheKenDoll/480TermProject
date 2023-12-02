package com.ensf480.backend.models;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Crew {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "pilot_id", referencedColumnName = "id")
  private Pilot pilot;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "copilot_id", referencedColumnName = "id")
  private Copilot copilot;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "crew_id", referencedColumnName = "id")
  private List<FlightAttendant> flightAttendants = new ArrayList<>();

  @Column(name = "airline_id")
  private long airlineId;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Crew(Pilot pilot, Copilot copilot, long airlineId) {
    this.pilot = pilot;
    this.copilot = copilot;
    this.airlineId = airlineId;
  }
}