package com.ensf480.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

  @Autowired
  private JavaMailSender mailSender;

  public void sendHtmlEmail(String email) throws MessagingException {
    if (email == null) {
      throw new IllegalArgumentException("Email cannot be null");
    }
    MimeMessage message = mailSender.createMimeMessage();

    message.setFrom(new InternetAddress("noreply@airlines.com"));
    message.setRecipients(MimeMessage.RecipientType.TO, email);
    message.setSubject("Flight confirmation");

    String htmlContent = "<h1>Flight Booking Confirmation</h1>" +
        "<p>Dear <strong>${name}</strong>,</p>" +
        "<p>We are pleased to confirm your flight booking with the following details:</p>" +
        "<table>" +
        "<tr><td>Flight Number:</td><td><strong>${flightNumber}</strong></td></tr>" +
        "<tr><td>Origin:</td><td><strong>${origin}</strong></td></tr>" +
        "<tr><td>Destination:</td><td><strong>${destination}</strong></td></tr>" +
        "<tr><td>Date:</td><td><strong>${date}</strong></td></tr>" +
        "<tr><td>Departure Time:</td><td><strong>${departureTime}</strong></td></tr>" +
        "<tr><td>Arrival Time:</td><td><strong>${arrivalTime}</strong></td></tr>" +
        "</table>" +
        "<p>Thank you for choosing our airline. We look forward to welcoming you on board.</p>" +
        "<p>Best regards,</p>" +
        "<p><strong>Etihad Airways Team</strong></p>";

    String name = "Axel Sanchez";
    String flightNumber = "AB123";
    String origin = "New York";
    String destination = "London";
    String date = "2023-12-25";
    String departureTime = "10:00 AM";
    String arrivalTime = "08:00 PM";
    String imageUrl = "https://logos-world.net/wp-content/uploads/2023/01/Etihad-Airways-Logo.png";
    String altText = "Image Description";
    int width = 370;
    int height = 200;

    htmlContent += "<p><img src='" + imageUrl + "' alt='" + altText +
        "' width='" + width + "' height='" + height + "' /></p>";

    htmlContent = htmlContent.replace("${name}", name);
    htmlContent = htmlContent.replace("${flightNumber}", flightNumber);
    htmlContent = htmlContent.replace("${origin}", origin);
    htmlContent = htmlContent.replace("${destination}", destination);
    htmlContent = htmlContent.replace("${date}", date);
    htmlContent = htmlContent.replace("${departureTime}", departureTime);
    htmlContent = htmlContent.replace("${arrivalTime}", arrivalTime);

    message.setContent(htmlContent, "text/html; charset=utf-8");

    mailSender.send(message);
  }
}