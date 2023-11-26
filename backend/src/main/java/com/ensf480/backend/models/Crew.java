package com.ensf480.backend.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
  @JoinColumn(name = "pilot_id", referencedColumnName = "id")
  private Pilot pilot;

  @OneToOne
  @JoinColumn(name = "copilot_id", referencedColumnName = "id")
  private Copilot copilot;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "crew_id", referencedColumnName = "id")
  private ArrayList<FlightAttendant> flightAttendants = new ArrayList<>();

  @Column(name = "airline_id")
  private long airlineId;

  @JsonIgnore
  @OneToOne(mappedBy = "crew")
  private Flight flight;

  public Crew(long id, Pilot pilot, Copilot copilot, ArrayList<FlightAttendant> flightAttendants, long airlineId,
      Flight flight) {
    this.id = id;
    this.pilot = pilot;
    this.copilot = copilot;
    this.flightAttendants = flightAttendants;
    this.airlineId = airlineId;
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

  public ArrayList<FlightAttendant> getFlightAttendants() {
    return flightAttendants;
  }

  public void setFlightAttendants(ArrayList<FlightAttendant> flightAttendants) {
    this.flightAttendants = flightAttendants;
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
    result = prime * result + ((pilot == null) ? 0 : pilot.hashCode());
    result = prime * result + ((copilot == null) ? 0 : copilot.hashCode());
    result = prime * result + ((flightAttendants == null) ? 0 : flightAttendants.hashCode());
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
    if (flightAttendants == null) {
      if (other.flightAttendants != null)
        return false;
    } else if (!flightAttendants.equals(other.flightAttendants))
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
    return "Crew [id=" + id + ", pilot=" + pilot + ", copilot=" + copilot + ", flightAttendants=" + flightAttendants
        + ", airlineId=" + airlineId + ", flight=" + flight + "]";
  }

}
