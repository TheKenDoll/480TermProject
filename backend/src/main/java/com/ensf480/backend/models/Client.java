package com.ensf480.backend.models;

import com.ensf480.backend.abstracts.Person;

import java.util.Objects;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Client extends Person {
  private String email;
  private String password;
  private String role;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Client(String email, String password, String role) {
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public Client() {
  }

  public Client(String firstName, String lastName, String address, String email, String password, String role) {
    super(firstName, lastName, address);
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public Client(long id, String firstName, String lastName, String address, String email, String password,
      String role, LocalDateTime createdAt, LocalDateTime updatedAt) {
    super(id, firstName, lastName, address);
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
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
    return Objects.hash(super.hashCode(), email, password, role);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (!(obj instanceof Client))
      return false;
    Client other = (Client) obj;
    return Objects.equals(email, other.email)
        && Objects.equals(password, other.password)
        && Objects.equals(role, other.role);
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
        + ", email=" + email + ", password=" + password + ", role=" + role + ", createdAt=" + createdAt + ", updatedAt="
        + updatedAt + "]";
  }

}
