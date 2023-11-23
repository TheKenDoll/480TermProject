package com.ensf480.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensf480.backend.models.Person;
import com.ensf480.backend.services.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping
  public List<Person> getPersons() {
    return personService.getPersons();
  }

  @PostMapping
  public Person postPerson() {
    return personService.postPerson();
  }
}