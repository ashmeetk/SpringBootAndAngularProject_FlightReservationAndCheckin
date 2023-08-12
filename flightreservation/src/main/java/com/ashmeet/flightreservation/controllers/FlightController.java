package com.ashmeet.flightreservation.controllers;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashmeet.flightreservation.entities.Flight;
import com.ashmeet.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping("findFlights")
	public String findFlights(@RequestParam(value = "from", required = false)String from, @RequestParam(value = "to", required = false)String to,
			@RequestParam(value = "departureDate", required = false) @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate, ModelMap modelMap)
	{
		LOGGER.info("inside findFlights() From: " + from + "To: " + "Departure Date: " + departureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Flights found are: " + flights);
		return "displayFlights";
	}
	
	@RequestMapping("admin/showAddFlight")
	public String showAddFlight(){
		LOGGER.info("inside method showAddFlight()");
		return "addFlight";
	}
	
	@RequestMapping(value="admin/saveFlight", method=RequestMethod.POST)
	public String saveFlight(@RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfDeparture, @RequestParam("arrivalCity") String arrivalCity,  
			@RequestParam("departureCity") String departureCity,  @RequestParam("operatingAirlines") String operatingAirlines, @RequestParam("flightNumber") String flightNumber, 
			@RequestParam("estimatedDepartureTime") String estimatedDepartureTime ){
		LOGGER.info("inside method saveFlight()");
		Flight flight = new Flight();
		flight.setArrivalCity(arrivalCity);
		flight.setDateOfDeparture(dateOfDeparture);
		flight.setDepartureCity(departureCity);
		flight.setFlightNumber(flightNumber);
		flight.setOperatingAirlines(operatingAirlines);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    try {
	        java.util.Date parsedDate = dateFormat.parse(estimatedDepartureTime);
	        Timestamp timestamp = new Timestamp(parsedDate.getTime());
	        flight.setEstimatedDepartureTime(timestamp);
	        
	    } catch (ParseException e) {
	    }
		flightRepository.save(flight);
		return "savedflight";
	}

}
