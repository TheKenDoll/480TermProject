package com.ensf480.backend.models;

import java.util.List;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Aircraft {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String model;
  private int manufactureYear;
  private int capacity;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
  private List<Seat> seats;

  @Column(name = "airline_id")
  private long airlineId;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Aircraft() {
  }

  public Aircraft(String model, int manufactureYear, int capacity, List<Seat> seats, long airlineId) {
    this.model = model;
    this.manufactureYear = manufactureYear;
    this.capacity = capacity;
    this.seats = seats;
    this.airlineId = airlineId;
  }

  public Aircraft(long id, String model, int manufactureYear, int capacity, List<Seat> seats, long airlineId,
      LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.model = model;
    this.manufactureYear = manufactureYear;
    this.capacity = capacity;
    this.seats = seats;
    this.airlineId = airlineId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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

  public int getManufactureYear() {
    return manufactureYear;
  }

  public void setManufactureYear(int manufactureYear) {
    this.manufactureYear = manufactureYear;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public List<Seat> getSeats() {
    return seats;
  }

  public void setSeats(List<Seat> seats) {
    this.seats = seats;
  }

  public long getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(long airlineId) {
    this.airlineId = airlineId;
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
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((model == null) ? 0 : model.hashCode());
    result = prime * result + manufactureYear;
    result = prime * result + capacity;
    result = prime * result + ((seats == null) ? 0 : seats.hashCode());
    result = prime * result + (int) (airlineId ^ (airlineId >>> 32));
    result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
    result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
    if (manufactureYear != other.manufactureYear)
      return false;
    if (capacity != other.capacity)
      return false;
    if (seats == null) {
      if (other.seats != null)
        return false;
    } else if (!seats.equals(other.seats))
      return false;
    if (airlineId != other.airlineId)
      return false;
    if (createdAt == null) {
      if (other.createdAt != null)
        return false;
    } else if (!createdAt.equals(other.createdAt))
      return false;
    if (updatedAt == null) {
      if (other.updatedAt != null)
        return false;
    } else if (!updatedAt.equals(other.updatedAt))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Aircraft [id=" + id + ", model=" + model + ", manufactureYear=" + manufactureYear + ", capacity=" + capacity
        + ", seats=" + seats + ", airlineId=" + airlineId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
        + "]";
  }

}
