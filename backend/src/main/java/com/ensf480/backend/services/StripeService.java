package com.ensf480.backend.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class StripeService {

  private String stripePublicKey;

  public StripeService() {
    Dotenv dotenv = Dotenv.load();
    stripePublicKey = dotenv.get("STRIPE_SECRET_KEY");
  }

  public PaymentIntent createPaymentIntent(double amount) throws StripeException {
    Stripe.apiKey = stripePublicKey;
    PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .setAmount(BigDecimal.valueOf(amount * 100).longValue())
        .setCurrency("CAD")
        .build();

    return PaymentIntent.create(params);
  }
}
