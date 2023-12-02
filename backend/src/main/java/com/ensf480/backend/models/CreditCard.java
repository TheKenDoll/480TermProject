package com.ensf480.backend.models;

import com.ensf480.backend.interfaces.PaymentStrategy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard implements PaymentStrategy {

  private long id;
  private String name;
  private String cardNumber;
  private String cvv;
  private String dateOfExpiry;

  @Override
  public void makePayment(double amount) {
    System.out.println("Payment made with credit card");
  }
}
