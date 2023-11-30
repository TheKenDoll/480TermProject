package com.ensf480.backend.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String seatNumber;
  private double price;
  private boolean available;
  private String seatClass;

  @Column(name = "aircraft_id")
  private long aircraftId;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Seat() {
  }

  public Seat(boolean available) {
    this.available = available;
  }

  public Seat(String seatNumber, double price, boolean available, String seatClass, long aircraftId) {
    this.seatNumber = seatNumber;
    this.price = price;
    this.available = available;
    this.aircraftId = aircraftId;
  }

  public Seat(long id, String seatNumber, double price, boolean available, String seatClass, long aircraftId,
      LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.seatNumber = seatNumber;
    this.price = price;
    this.available = available;
    this.aircraftId = aircraftId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean getAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public long getAircraftId() {
    return aircraftId;
  }

  public void setAircraftId(long aircraftId) {
    this.aircraftId = aircraftId;
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
    result = prime * result + ((seatNumber == null) ? 0 : seatNumber.hashCode());
    long temp;
    temp = Double.doubleToLongBits(price);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + (available ? 1231 : 1237);
    result = prime * result + ((seatClass == null) ? 0 : seatClass.hashCode());
    result = prime * result + (int) (aircraftId ^ (aircraftId >>> 32));
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
    Seat other = (Seat) obj;
    if (id != other.id)
      return false;
    if (seatNumber == null) {
      if (other.seatNumber != null)
        return false;
    } else if (!seatNumber.equals(other.seatNumber))
      return false;
    if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
      return false;
    if (available != other.available)
      return false;
    if (seatClass == null) {
      if (other.seatClass != null)
        return false;
    } else if (!seatClass.equals(other.seatClass))
      return false;
    if (aircraftId != other.aircraftId)
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
    return "Seat [id=" + id + ", seatNumber=" + seatNumber + ", price=" + price + ", available=" + available
        + ", seatClass=" + seatClass + ", aircraftId=" + aircraftId + ", createdAt=" + createdAt + ", updatedAt="
        + updatedAt + "]";
  }
}
