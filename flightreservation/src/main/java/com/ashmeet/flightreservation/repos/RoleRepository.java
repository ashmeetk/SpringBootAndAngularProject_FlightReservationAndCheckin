package com.ashmeet.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashmeet.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
