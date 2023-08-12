package com.ashmeet.flightreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FlightreservationApplication /*extends SpringBootServletInitializer*/{

//  Implement below method of SpringBootServletInitializer class only when you create war application for deployment
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//		return builder.sources(FlightreservationApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}

}
