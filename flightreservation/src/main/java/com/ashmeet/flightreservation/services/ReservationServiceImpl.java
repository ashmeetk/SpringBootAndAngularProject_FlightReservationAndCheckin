package com.ashmeet.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashmeet.flightreservation.dto.ReservationRequest;
import com.ashmeet.flightreservation.entities.Flight;
import com.ashmeet.flightreservation.entities.Passenger;
import com.ashmeet.flightreservation.entities.Reservation;
import com.ashmeet.flightreservation.repos.FlightRepository;
import com.ashmeet.flightreservation.repos.PassengerRepository;
import com.ashmeet.flightreservation.repos.ReservationRepository;
import com.ashmeet.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.ashmeet.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;
	

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	PDFGenerator pdfGenerator;

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("inside bookFlight()");

		// Make payment.
		// Throw Exception if payment is unsuccessful otherwise proceed ahead.

		Long flightId = request.getFlightId();
		LOGGER.info("Fetching flight for flight id: " + flightId);
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("Saving the passenger: " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		LOGGER.info("Saving the reservation: " + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = ITINERARY_DIR
				+ savedReservation.getId() + ".pdf";
		LOGGER.info("Generating the itinerary");
		pdfGenerator.generateItineary(savedReservation, filePath);

		return savedReservation;
	}

}
//   /Users/I534875/Documents/SpringFramework_In_Easy_Steps/reservations