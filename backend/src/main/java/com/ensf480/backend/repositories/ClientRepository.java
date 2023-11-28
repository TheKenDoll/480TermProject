package com.ensf480.backend.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensf480.backend.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  Optional<Client> findByEmail(String email);
}
