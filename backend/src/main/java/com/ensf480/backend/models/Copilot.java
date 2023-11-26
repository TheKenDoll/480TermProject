package com.ensf480.backend.models;

import com.ensf480.backend.abstracts.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Copilot extends Person {

  private int serviceYears;

  @JsonIgnore
  @OneToOne(mappedBy = "copilot")
  private Crew crew;

  public Copilot() {
  }

  public Copilot(String firstName, String lastName, String address, int serviceYears) {
    super(firstName, lastName, address);
    this.serviceYears = serviceYears;
  }

  public Copilot(long id, String firstName, String lastName, String address, int serviceYears, Crew crew) {
    super(id, firstName, lastName, address);
    this.serviceYears = serviceYears;
    this.crew = crew;
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
    if (!(o instanceof Copilot))
      return false;
    if (!super.equals(o))
      return false;
    Copilot copilot = (Copilot) o;
    return Objects.equals(serviceYears, copilot.serviceYears);
  }

  @Override
  public String toString() {
    return "Copilot [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
        + ", serviceYears=" + serviceYears + "]";
  }

}
