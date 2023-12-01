package com.ensf480.backend.models;

import com.ensf480.backend.abstracts.Person;

import java.util.Objects;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Pilot extends Person {
  private int serviceYears;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Pilot() {
  }

  public Pilot(String firstName, String lastName, String address, int serviceYears) {
    super(firstName, lastName, address);
    this.serviceYears = serviceYears;
  }

  public Pilot(long id, String firstName, String lastName, String address, int serviceYears) {
    super(id, firstName, lastName, address);
    this.serviceYears = serviceYears;
  }

  public int getServiceYears() {
    return serviceYears;
  }

  public void setServiceYears(int serviceYears) {
    this.serviceYears = serviceYears;
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
    if (!(o instanceof Pilot))
      return false;
    if (!super.equals(o))
      return false;
    Pilot pilot = (Pilot) o;
    return Objects.equals(serviceYears, pilot.serviceYears);
  }

  @Override
  public String toString() {
    return "Pilot [id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", address = " + address
        + ", serviceYears = " + serviceYears + ", createdAt = " + createdAt + ", updatedAt = " + updatedAt + "]";
  }
}
