package com.ensf480.backend.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.ChargeRequest;
import io.github.cdimascio.dotenv.Dotenv;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

  private String stripePublicKey;

  public CheckoutController() {
    Dotenv dotenv = Dotenv.load();
    stripePublicKey = dotenv.get("STRIPE_PUBLIC_KEY");
  }

  @PostMapping
  public String checkout(Model model) {
    model.addAttribute("amount", 50 * 100); // in cents
    model.addAttribute("stripePublicKey", stripePublicKey);
    model.addAttribute("currency", ChargeRequest.Currency.EUR);
    return "checkout";
  }
}
