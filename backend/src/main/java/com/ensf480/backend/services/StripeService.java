package com.ensf480.backend.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import jakarta.annotation.PostConstruct;

@Service
public class StripeService {

  @Value("${STRIPE_SECRET_KEY}")
  private String stripePublicKey;

  @PostConstruct
  public void init() {
    Stripe.apiKey = stripePublicKey;
  }

  public PaymentIntent createPaymentIntent(double amount) throws StripeException {
    PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .setAmount(BigDecimal.valueOf(amount * 100).longValue())
        .setCurrency("CAD")
        .build();

    return PaymentIntent.create(params);
  }
}
