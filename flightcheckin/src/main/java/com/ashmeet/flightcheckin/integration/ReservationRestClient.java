package com.ashmeet.flightcheckin.integration;

import com.ashmeet.flightcheckin.integration.dto.Reservation;
import com.ashmeet.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
