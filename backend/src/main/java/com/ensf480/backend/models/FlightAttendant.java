package com.ensf480.backend.models;

import com.ensf480.backend.abstracts.Person;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class FlightAttendant extends Person {

  private int serviceYears;

  @ManyToOne
  @JoinColumn(name = "crew_id")
  private Crew crew;

  public FlightAttendant() {
  }

  public FlightAttendant(String firstName, String lastName, String address, int serviceYears) {
    super(firstName, lastName, address);
    this.serviceYears = serviceYears;
  }

  public FlightAttendant(long id, String firstName, String lastName, String address, int serviceYears) {
    super(id, firstName, lastName, address);
    this.serviceYears = serviceYears;
  }

  public int getServiceYears() {
    return serviceYears;
  }

  public void setServiceYears(int serviceYears) {
    this.serviceYears = serviceYears;
  }

  public Crew getCrew() {
    return crew;
  }

  public void setCrew(Crew crew) {
    this.crew = crew;
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
        + address + ", serviceYears = " + serviceYears + ", crew = " + crew + "]";
  }

}
