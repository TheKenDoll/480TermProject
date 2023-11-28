package com.ensf480.backend.models;

import com.ensf480.backend.abstracts.Person;

import java.util.Objects;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Client extends Person {

  @Column(unique = true)
  private String username;

  private String email;
  private String password;

  @ManyToMany
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public Client() {
  }

  public Client(String firstName, String lastName, String address, String email, String password, Set<Role> roles) {
    super(firstName, lastName, address);
    this.email = email;
    this.password = password;
    this.roles = roles;
  }

  public Client(long id, String firstName, String lastName, String address, String email, String password,
      Set<Role> roles, LocalDateTime createdAt, LocalDateTime updatedAt) {
    super(id, firstName, lastName, address);
    this.email = email;
    this.password = password;
    this.roles = roles;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
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
    return Objects.hash(super.hashCode(), email, password, roles);
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
        && Objects.equals(roles, other.roles);
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
        + ", email=" + email + ", password=" + password + ", roles=" + roles + ", createdAt=" + createdAt
        + ", updatedAt=" + updatedAt + "]";
  }
}