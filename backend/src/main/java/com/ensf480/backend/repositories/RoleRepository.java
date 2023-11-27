package com.ensf480.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensf480.backend.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
