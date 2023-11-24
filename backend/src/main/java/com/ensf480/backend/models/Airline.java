package com.ensf480.backend.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Airline {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String country;

  @OneToMany(mappedBy = "airline")
  private List<Crew> crews;

  @OneToMany(mappedBy = "airline")
  private List<Aircraft> aircrafts;

  @OneToMany(mappedBy = "airline")
  private List<Flight> flights;

  public Airline() {
  }

  public Airline(String name, String country) {
    this.name = name;
    this.country = country;
  }

  public Airline(long id, String name, String country, List<Crew> crews, List<Aircraft> aircrafts,
      List<Flight> flights) {
    this.id = id;
    this.name = name;
    this.country = country;
    this.crews = crews;
    this.aircrafts = aircrafts;
    this.flights = flights;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public List<Crew> getCrews() {
    return crews;
  }

  public void setCrews(List<Crew> crews) {
    this.crews = crews;
  }

  public List<Aircraft> getAircrafts() {
    return aircrafts;
  }

  public void setAircrafts(List<Aircraft> aircrafts) {
    this.aircrafts = aircrafts;
  }

  public List<Flight> getFlights() {
    return flights;
  }

  public void setFlights(List<Flight> flights) {
    this.flights = flights;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((crews == null) ? 0 : crews.hashCode());
    result = prime * result + ((aircrafts == null) ? 0 : aircrafts.hashCode());
    result = prime * result + ((flights == null) ? 0 : flights.hashCode());
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
    Airline other = (Airline) obj;
    if (id != other.id)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (country == null) {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    if (crews == null) {
      if (other.crews != null)
        return false;
    } else if (!crews.equals(other.crews))
      return false;
    if (aircrafts == null) {
      if (other.aircrafts != null)
        return false;
    } else if (!aircrafts.equals(other.aircrafts))
      return false;
    if (flights == null) {
      if (other.flights != null)
        return false;
    } else if (!flights.equals(other.flights))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Airline [id=" + id + ", name=" + name + ", country=" + country + ", crews=" + crews + ", aircrafts="
        + aircrafts + ", flights=" + flights + "]";
  }
}
