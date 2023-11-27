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
<<<<<<< HEAD:backend/src/main/java/com/ensf480/backend/models/User.java
public class User extends Person {

  @Column(unique = true)
  private String username;
=======
public class Client extends Person {
>>>>>>> e2ad682ec90fd7b3d50f3c8514d962be7746d4f9:backend/src/main/java/com/ensf480/backend/models/Client.java
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

  public Client(String email, String password, String role) {
    this.email = email;
    this.password = password;
    //this.roles = roles;

  }

  public Client() {
  }

<<<<<<< HEAD:backend/src/main/java/com/ensf480/backend/models/User.java
  public User(String firstName, String lastName, String address, String email, String password, Set<Role> roles) {
=======
  public Client(String firstName, String lastName, String address, String email, String password, String role) {
>>>>>>> e2ad682ec90fd7b3d50f3c8514d962be7746d4f9:backend/src/main/java/com/ensf480/backend/models/Client.java
    super(firstName, lastName, address);
    this.email = email;
    this.password = password;
    this.roles = roles;


  }

<<<<<<< HEAD:backend/src/main/java/com/ensf480/backend/models/User.java
  public User(long id, String firstName, String lastName, String address, String email, String password, Set<Role> roles) {
=======
  public Client(long id, String firstName, String lastName, String address, String email, String password,
      String role) {
>>>>>>> e2ad682ec90fd7b3d50f3c8514d962be7746d4f9:backend/src/main/java/com/ensf480/backend/models/Client.java
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
        + ", email=" + email + ", password=" + password + ", role=" + roles + "]";
  }
}

