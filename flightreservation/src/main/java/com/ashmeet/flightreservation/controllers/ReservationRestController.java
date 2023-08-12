package com.ashmeet.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashmeet.flightreservation.dto.ReservationUpdateRequest;
import com.ashmeet.flightreservation.entities.Reservation;
import com.ashmeet.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id){
		LOGGER.info("inside findReservation() for id: " + id);
		return reservationRepository.findById(id).get();
	}
	
	@RequestMapping("reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("inside updateReservation() for: " + request);
		Reservation reservation = reservationRepository.findById(request.getId()).get(); 
		reservation.setCheckedIn(request.getCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		LOGGER.info("Saving Reservation");
		return reservationRepository.save(reservation);
		
	}

}
