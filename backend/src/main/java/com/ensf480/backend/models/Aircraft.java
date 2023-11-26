package com.ensf480.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Aircraft {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String model;
  private int year;
  private int capacity;

  @Column(name = "airline_id")
  private long airlineId;

  @JsonIgnore
  @OneToOne(mappedBy = "aircraft")
  private Flight flight;

  public Aircraft() {
  }

  public Aircraft(String model, int year, int capacity, long airlineId) {
    this.model = model;
    this.year = year;
    this.capacity = capacity;
    this.airlineId = airlineId;
  }

  public Aircraft(long id, String model, int year, int capacity, long airlineId, Flight flight) {
    this.id = id;
    this.model = model;
    this.year = year;
    this.capacity = capacity;
    this.airlineId = airlineId;
    this.flight = flight;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public long getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(long airlineId) {
    this.airlineId = airlineId;
  }

  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((model == null) ? 0 : model.hashCode());
    result = prime * result + year;
    result = prime * result + capacity;
    result = prime * result + (int) (airlineId ^ (airlineId >>> 32));
    result = prime * result + ((flight == null) ? 0 : flight.hashCode());
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
    Aircraft other = (Aircraft) obj;
    if (id != other.id)
      return false;
    if (model == null) {
      if (other.model != null)
        return false;
    } else if (!model.equals(other.model))
      return false;
    if (year != other.year)
      return false;
    if (capacity != other.capacity)
      return false;
    if (airlineId != other.airlineId)
      return false;
    if (flight == null) {
      if (other.flight != null)
        return false;
    } else if (!flight.equals(other.flight))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Aircraft [id=" + id + ", model=" + model + ", year=" + year + ", capacity=" + capacity + ", airlineId="
        + airlineId + ", flight=" + flight + "]";
  }
}
