package com.ensf480.backend.models;

import java.util.Date;

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
public class Flight {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int number;
  private String destination;
  private String origin;
  private Date departureTime;
  private Date arrivalTime;

  @OneToOne
  @JoinColumn(name = "aircraft_id")
  private Aircraft aircraft;

  @OneToOne
  @JoinColumn(name = "crew_id")
  private Crew crew;

  @ManyToOne
  @JoinColumn(name = "airline_id")
  private Airline airline;

  public Flight() {
  }

  public Flight(int number, String destination, String origin, Date departureTime, Date arrivalTime, Aircraft aircraft,
      Crew crew, Airline airline) {
    this.number = number;
    this.destination = destination;
    this.origin = origin;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.aircraft = aircraft;
    this.crew = crew;
    this.airline = airline;
  }

  public Flight(long id, int number, String destination, String origin, Date departureTime, Date arrivalTime,
      Aircraft aircraft, Crew crew, Airline airline) {
    this.id = id;
    this.number = number;
    this.destination = destination;
    this.origin = origin;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.aircraft = aircraft;
    this.crew = crew;
    this.airline = airline;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
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

  public Date getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }

  public Date getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(Date arrivalTime) {
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

  public Airline getAirline() {
    return airline;
  }

  public void setAirline(Airline airline) {
    this.airline = airline;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + number;
    result = prime * result + ((destination == null) ? 0 : destination.hashCode());
    result = prime * result + ((origin == null) ? 0 : origin.hashCode());
    result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
    result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
    result = prime * result + ((aircraft == null) ? 0 : aircraft.hashCode());
    result = prime * result + ((crew == null) ? 0 : crew.hashCode());
    result = prime * result + ((airline == null) ? 0 : airline.hashCode());
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
    if (number != other.number)
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
    if (airline == null) {
      if (other.airline != null)
        return false;
    } else if (!airline.equals(other.airline))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Flight [id=" + id + ", number=" + number + ", destination=" + destination + ", origin=" + origin
        + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", aircraft=" + aircraft + ", crew="
        + crew + ", airline=" + airline + "]";
  }
}
