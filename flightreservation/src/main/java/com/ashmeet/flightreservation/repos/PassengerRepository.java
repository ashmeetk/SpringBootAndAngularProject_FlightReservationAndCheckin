package com.ashmeet.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashmeet.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
