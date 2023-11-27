package com.ensf480.backend.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensf480.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);


    //Optional<User> existsByEmail(String email);
    //Boolean exitsByEmail(String email);


}
