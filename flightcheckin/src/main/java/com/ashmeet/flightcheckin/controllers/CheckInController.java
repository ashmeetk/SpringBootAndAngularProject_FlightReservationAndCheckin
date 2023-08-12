package com.ashmeet.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashmeet.flightcheckin.integration.ReservationRestClient;
import com.ashmeet.flightcheckin.integration.dto.Reservation;
import com.ashmeet.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {
	
	@Autowired
	private ReservationRestClient reservationRestClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin(){
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap){
		Reservation reservation = reservationRestClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	@Transactional
	public String completeCheckIn(@RequestParam("numberOfBags") int numberOfBags, @RequestParam("reservationId") Long reservationId){
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		Reservation reservation = reservationRestClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
	}
	
	
}
