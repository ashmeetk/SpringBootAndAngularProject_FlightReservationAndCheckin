package com.ashmeet.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashmeet.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
