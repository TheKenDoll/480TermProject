package com.ensf480.backend.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ensf480.backend.models.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;

@Service
public class StripeService {

  private String secretKey;

  @PostConstruct
  public void init() {
    Dotenv dotenv = Dotenv.load();
    secretKey = dotenv.get("STRIPE_SECRET_KEY");
    Stripe.apiKey = secretKey;
  }

  public Charge charge(ChargeRequest chargeRequest)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, CardException, APIException {
    Map<String, Object> chargeParams = new HashMap<>();
    chargeParams.put("amount", chargeRequest.getAmount());
    chargeParams.put("currency", chargeRequest.getCurrency());
    chargeParams.put("description", chargeRequest.getDescription());
    chargeParams.put("source", chargeRequest.getStripeToken());
    return Charge.create(chargeParams);
  }
}
