package com.ashmeet.flightreservation.services;

import com.ashmeet.flightreservation.dto.ReservationRequest;
import com.ashmeet.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
