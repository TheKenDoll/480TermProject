package com.ensf480.backend.models;

import com.ensf480.backend.interfaces.PaymentStrategy;

public class CreditCard implements PaymentStrategy {

  private long id;
  private String name;
  private String cardNumber;
  private String cvv;
  private String dateOfExpiry;

  public CreditCard() {
  }

  public CreditCard(long id, String name, String cardNumber, String cvv, String dateOfExpiry) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.cvv = cvv;
    this.dateOfExpiry = dateOfExpiry;
  }

  @Override
  public void makePayment(double amount) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'makePayment'");
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  public String getDateOfExpiry() {
    return dateOfExpiry;
  }

  public void setDateOfExpiry(String dateOfExpiry) {
    this.dateOfExpiry = dateOfExpiry;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
    result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
    result = prime * result + ((dateOfExpiry == null) ? 0 : dateOfExpiry.hashCode());
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
    CreditCard other = (CreditCard) obj;
    if (id != other.id)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (cardNumber == null) {
      if (other.cardNumber != null)
        return false;
    } else if (!cardNumber.equals(other.cardNumber))
      return false;
    if (cvv == null) {
      if (other.cvv != null)
        return false;
    } else if (!cvv.equals(other.cvv))
      return false;
    if (dateOfExpiry == null) {
      if (other.dateOfExpiry != null)
        return false;
    } else if (!dateOfExpiry.equals(other.dateOfExpiry))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "CreditCardPayment [id=" + id + ", name=" + name + ", cardNumber=" + cardNumber + ", cvv=" + cvv
        + ", dateOfExpiry=" + dateOfExpiry + "]";
  }

}
