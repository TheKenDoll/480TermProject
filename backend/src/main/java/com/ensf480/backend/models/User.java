package com.ensf480.backend.models;

import com.ensf480.backend.abstracts.Person;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class User extends Person {

  @Column(unique = true)
  private String username;
  private String email;
  private String password;

  @ManyToMany
  @JoinTable(name = "user_role", joinColumns =@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id") )
  private Set<Role> roles;


  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public User(String email, String password, String role) {
    this.email = email;
    this.password = password;
    //this.roles = roles;

  }

  public User() {
  }

  public User(String firstName, String lastName, String address, String email, String password, Set<Role> roles) {
    super(firstName, lastName, address);
    this.email = email;
    this.password = password;
    this.roles = roles;


  }

  public User(long id, String firstName, String lastName, String address, String email, String password, Set<Role> roles) {
    super(id, firstName, lastName, address);
    this.email = email;
    this.password = password;
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
    if (!(obj instanceof User))
      return false;
    User other = (User) obj;
    return Objects.equals(email, other.email)
        && Objects.equals(password, other.password)
        && Objects.equals(roles, other.roles);
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
        + ", email=" + email + ", password=" + password + ", role=" + roles + "]";
  }
}

