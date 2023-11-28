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

@Entity
@Table
public class Flight {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
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

  public Flight() {
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

  public Flight(long id, String number, String destination, String origin, String departureTime, String arrivalTime,
      Aircraft aircraft, Crew crew, long airlineId, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.number = number;
    this.destination = destination;
    this.origin = origin;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.aircraft = aircraft;
    this.crew = crew;
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

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public Aircraft getAircraft() {
    return aircraft;
  }

  public void setAircraft(Aircraft aircraft) {
    this.aircraft = aircraft;
  }

  public Crew getCrew() {
    return crew;
  }

  public void setCrew(Crew crew) {
    this.crew = crew;
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
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    result = prime * result + ((destination == null) ? 0 : destination.hashCode());
    result = prime * result + ((origin == null) ? 0 : origin.hashCode());
    result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
    result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
    result = prime * result + ((aircraft == null) ? 0 : aircraft.hashCode());
    result = prime * result + ((crew == null) ? 0 : crew.hashCode());
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
    Flight other = (Flight) obj;
    if (id != other.id)
      return false;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;
    if (destination == null) {
      if (other.destination != null)
        return false;
    } else if (!destination.equals(other.destination))
      return false;
    if (origin == null) {
      if (other.origin != null)
        return false;
    } else if (!origin.equals(other.origin))
      return false;
    if (departureTime == null) {
      if (other.departureTime != null)
        return false;
    } else if (!departureTime.equals(other.departureTime))
      return false;
    if (arrivalTime == null) {
      if (other.arrivalTime != null)
        return false;
    } else if (!arrivalTime.equals(other.arrivalTime))
      return false;
    if (aircraft == null) {
      if (other.aircraft != null)
        return false;
    } else if (!aircraft.equals(other.aircraft))
      return false;
    if (crew == null) {
      if (other.crew != null)
        return false;
    } else if (!crew.equals(other.crew))
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
    return "Flight [id=" + id + ", number=" + number + ", destination=" + destination + ", origin=" + origin
        + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", aircraft=" + aircraft + ", crew="
        + crew + ", airlineId=" + airlineId + ", createdAt=" + createdAt + ", updatedAt="
        + updatedAt + "]";
  }

}
