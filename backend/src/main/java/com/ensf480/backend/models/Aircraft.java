package com.ensf480.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

  @ManyToOne
  @JoinColumn(name = "airline_id")
  private Airline airline;

  @OneToOne(mappedBy = "aircraft")
  private Flight flight;

  public Aircraft() {
  }

  public Aircraft(String model, int year, int capacity, Airline airline) {
    this.model = model;
    this.year = year;
    this.capacity = capacity;
    this.airline = airline;
  }

  public Aircraft(long id, String model, int year, int capacity, Airline airline, Flight flight) {
    this.id = id;
    this.model = model;
    this.year = year;
    this.capacity = capacity;
    this.airline = airline;
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

  public Airline getAirline() {
    return airline;
  }

  public void setAirline(Airline airline) {
    this.airline = airline;
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
    result = prime * result + ((airline == null) ? 0 : airline.hashCode());
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
    if (airline == null) {
      if (other.airline != null)
        return false;
    } else if (!airline.equals(other.airline))
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
    return "Aircraft [id=" + id + ", model=" + model + ", year=" + year + ", capacity=" + capacity + ", airline="
        + airline + ", flight=" + flight + "]";
  }
}
