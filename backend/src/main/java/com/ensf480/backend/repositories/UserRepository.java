package com.ensf480.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensf480.backend.models.UserApp;

public interface UserRepository extends JpaRepository<UserApp, Long> {
  Optional<UserApp> findByEmail(String email);

}
