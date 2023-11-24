package com.ensf480.backend.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Crew {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne
  @JoinColumn(name = "pilot_id")
  private Pilot pilot;

  @OneToOne
  @JoinColumn(name = "copilot_id")
  private Copilot copilot;

  @ManyToOne
  @JoinColumn(name = "airline_id")
  private Airline airline;

  @OneToMany(mappedBy = "crew")
  private List<FlightAttendant> flightAttendants;

  @OneToOne(mappedBy = "crew")
  private Flight flight;

  public Crew() {
  }

  public Crew(Pilot pilot, Copilot copilot, Airline airline) {
    this.pilot = pilot;
    this.copilot = copilot;
    this.airline = airline;
  }

  public Crew(long id, Pilot pilot, Copilot copilot, Airline airline, List<FlightAttendant> flightAttendants,
      Flight flight) {
    this.id = id;
    this.pilot = pilot;
    this.copilot = copilot;
    this.airline = airline;
    this.flightAttendants = flightAttendants;
    this.flight = flight;
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

  public Airline getAirline() {
    return airline;
  }

  public void setAirline(Airline airline) {
    this.airline = airline;
  }

  public List<FlightAttendant> getFlightAttendants() {
    return flightAttendants;
  }

  public void setFlightAttendants(List<FlightAttendant> flightAttendants) {
    this.flightAttendants = flightAttendants;
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
    result = prime * result + ((pilot == null) ? 0 : pilot.hashCode());
    result = prime * result + ((copilot == null) ? 0 : copilot.hashCode());
    result = prime * result + ((airline == null) ? 0 : airline.hashCode());
    result = prime * result + ((flightAttendants == null) ? 0 : flightAttendants.hashCode());
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
    if (airline == null) {
      if (other.airline != null)
        return false;
    } else if (!airline.equals(other.airline))
      return false;
    if (flightAttendants == null) {
      if (other.flightAttendants != null)
        return false;
    } else if (!flightAttendants.equals(other.flightAttendants))
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
    return "Crew [id=" + id + ", pilot=" + pilot + ", copilot=" + copilot + ", airline=" + airline
        + ", flightAttendants=" + flightAttendants + ", flight=" + flight + "]";
  }

}
