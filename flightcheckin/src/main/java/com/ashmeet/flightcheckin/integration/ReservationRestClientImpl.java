package com.ashmeet.flightcheckin.integration;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ashmeet.flightcheckin.integration.dto.Reservation;
import com.ashmeet.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	@Value("${com.ashmeet.flightcheckin.flightreservation.url}")
	private String RESERVATION_REST_URL;

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(URI.create(RESERVATION_REST_URL+ "/" + id), Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(URI.create(RESERVATION_REST_URL), request, Reservation.class);
		return reservation;
	}

}
