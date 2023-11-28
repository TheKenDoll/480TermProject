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

@Entity
@Table
public class Crew {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
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

  public Crew() {
  }

  public Crew(Pilot pilot, Copilot copilot, long airlineId) {
    this.pilot = pilot;
    this.copilot = copilot;
    this.airlineId = airlineId;
  }

  public Crew(long id, Pilot pilot, Copilot copilot, List<FlightAttendant> flightAttendants, long airlineId,
      LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.pilot = pilot;
    this.copilot = copilot;
    this.flightAttendants = flightAttendants;
    this.airlineId = airlineId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Pilot getPilot() {
    return pilot;
  }

  public void setPilot(Pilot pilot) {
    this.pilot = pilot;
  }

  public Copilot getCopilot() {
    return copilot;
  }

  public void setCopilot(Copilot copilot) {
    this.copilot = copilot;
  }

  public List<FlightAttendant> getFlightAttendants() {
    return flightAttendants;
  }

  public void setFlightAttendants(List<FlightAttendant> flightAttendants) {
    this.flightAttendants = flightAttendants;
  }

  public long getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(long airlineId) {
    this.airlineId = airlineId;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((pilot == null) ? 0 : pilot.hashCode());
    result = prime * result + ((copilot == null) ? 0 : copilot.hashCode());
    result = prime * result + ((flightAttendants == null) ? 0 : flightAttendants.hashCode());
    result = prime * result + (int) (airlineId ^ (airlineId >>> 32));
    result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
    result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Crew other = (Crew) obj;
    if (id != other.id)
      return false;
    if (pilot == null) {
      if (other.pilot != null)
        return false;
    } else if (!pilot.equals(other.pilot))
      return false;
    if (copilot == null) {
      if (other.copilot != null)
        return false;
    } else if (!copilot.equals(other.copilot))
      return false;
    if (flightAttendants == null) {
      if (other.flightAttendants != null)
        return false;
    } else if (!flightAttendants.equals(other.flightAttendants))
      return false;
    if (airlineId != other.airlineId)
      return false;
    if (createdAt == null) {
      if (other.createdAt != null)
        return false;
    } else if (!createdAt.equals(other.createdAt))
      return false;
    if (updatedAt == null) {
      if (other.updatedAt != null)
        return false;
    } else if (!updatedAt.equals(other.updatedAt))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Crew [id=" + id + ", pilot=" + pilot + ", copilot=" + copilot + ", flightAttendants=" + flightAttendants
        + ", airlineId=" + airlineId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
  }

}