package com.ensf480.backend.models;

import com.ensf480.backend.abstracts.Person;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class User extends Person {
  private String email;
  private String password;
  private String role;

  public User(String email, String password, String role) {
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public User() {
  }

  public User(String firstName, String lastName, String address, String email, String password, String role) {
    super(firstName, lastName, address);
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public User(long id, String firstName, String lastName, String address, String email, String password, String role) {
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
    if (!(obj instanceof User))
      return false;
    User other = (User) obj;
    return Objects.equals(email, other.email)
        && Objects.equals(password, other.password)
        && Objects.equals(role, other.role);
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
        + ", email=" + email + ", password=" + password + ", role=" + role + "]";
  }

}
