package com.ensf480.backend.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.stripe.model.PaymentIntent;

import com.ensf480.backend.services.StripeService;
import com.stripe.exception.StripeException;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

  @Autowired
  public StripeService stripeService;

  @PostMapping
  public ResponseEntity<?> createPaymentIntent(@RequestParam("total") double total) {
    try {
      PaymentIntent paymentIntent = stripeService.createPaymentIntent(total);
      Map<String, String> response = new HashMap<>();
      response.put("client_secret", paymentIntent.getClientSecret());
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (StripeException e) {
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
