package com.ensf480.backend.models;

import com.ensf480.backend.abstracts.Person;

import java.util.Objects;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class FlightAttendant extends Person {

  private int serviceYears;

  @Column(name = "crew_id")
  private long crewId;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public FlightAttendant() {
  }

  public FlightAttendant(String firstName, String lastName, String address, int serviceYears, long crewId) {
    super(firstName, lastName, address);
    this.serviceYears = serviceYears;
    this.crewId = crewId;
  }

  public FlightAttendant(long id, String firstName, String lastName, String address, int serviceYears, long crewId,
      LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    super(id, firstName, lastName, address);
    this.serviceYears = serviceYears;
    this.crewId = crewId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public int getServiceYears() {
    return serviceYears;
  }

  public void setServiceYears(int serviceYears) {
    this.serviceYears = serviceYears;
  }

  public long getCrewId() {
    return crewId;
  }

  public void setCrewId(long crewId) {
    this.crewId = crewId;
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
    return Objects.hash(super.hashCode(), serviceYears);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof FlightAttendant))
      return false;
    if (!super.equals(o))
      return false;
    FlightAttendant that = (FlightAttendant) o;
    return Objects.equals(serviceYears, that.serviceYears);
  }

  @Override
  public String toString() {
    return "FlightAttendant [id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", address = "
        + address + ", serviceYears = " + serviceYears + ", crew = " + crewId + ", createdAt = " + createdAt
        + ", updatedAt = " + updatedAt + "]";
  }

}
