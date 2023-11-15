package com.ensf480.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "person_sequence")
  private long id;
  private String FName;
  private String LName;
  private String Address;
  private String email;

  public Person() {
  }

  public Person(String fName, String lName, String address, String email) {
    FName = fName;
    LName = lName;
    Address = address;
    this.email = email;
  }

  public Person(long id, String fName, String lName, String address, String email) {
    this.id = id;
    FName = fName;
    LName = lName;
    Address = address;
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFName() {
    return FName;
  }

  public void setFName(String fName) {
    FName = fName;
  }

  public String getLName() {
    return LName;
  }

  public void setLName(String lName) {
    LName = lName;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((FName == null) ? 0 : FName.hashCode());
    result = prime * result + ((LName == null) ? 0 : LName.hashCode());
    result = prime * result + ((Address == null) ? 0 : Address.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
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
    Person other = (Person) obj;
    if (id != other.id)
      return false;
    if (FName == null) {
      if (other.FName != null)
        return false;
    } else if (!FName.equals(other.FName))
      return false;
    if (LName == null) {
      if (other.LName != null)
        return false;
    } else if (!LName.equals(other.LName))
      return false;
    if (Address == null) {
      if (other.Address != null)
        return false;
    } else if (!Address.equals(other.Address))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", FName=" + FName + ", LName=" + LName + ", Address=" + Address + ", email=" + email
        + "]";
  }

}
