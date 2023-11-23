package com.ensf480.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensf480.backend.models.Person;
import com.ensf480.backend.repositories.PersonRepository;
import java.util.List;

@Service
public class PersonService {
  @Autowired
  private PersonRepository personRepository;

  public List<Person> getPersons() {
    return personRepository.findAll();
  }

  public Person postPerson() {
    return personRepository.save(new Person("John", "Doe", "1234 Main St", ""));
  }
}