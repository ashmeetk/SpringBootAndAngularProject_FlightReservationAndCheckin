package com.ashmeet.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashmeet.flightreservation.entities.User;
import com.ashmeet.flightreservation.repos.UserRepository;
import com.ashmeet.flightreservation.services.SecurityService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired 
	private UserRepository userRepository;
	
//	@Autowired
//	private SecurityService securityService;
	
//	@Autowired
//	BCryptPasswordEncoder encoder;

	@RequestMapping("/showReg")
	public String showRegistrationPage(){
		LOGGER.info("inside showRegistrationPage()");
		return "login/registerUser";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user){
		LOGGER.info("inside register()" + user);
//		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("email")String email, @RequestParam("password")String password, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		LOGGER.info("inside login() and the email is: " + email);
//		boolean loginResponse = securityService.login(email, password, request, response);
//		if(loginResponse){
//			return "findFlights";
//		}
//		else {
//			modelMap.addAttribute("msg", "Invalid Username or Password. Please try again.");
//		}
		User user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password))
			return "findFlights";
		else
		{
			modelMap.addAttribute("msg", "Invalid Username or Password. Please try again.");
		}
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage(){
		LOGGER.info("inside showLoginPage()");
		return "login/login";
	}
}
