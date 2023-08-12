//package com.ashmeet.flightreservation.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.context.DelegatingSecurityContextRepository;
//import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
//import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
//import org.springframework.security.web.context.SecurityContextRepository;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//	
//	@Bean
//	SecurityContextRepository securityContextRepo()
//	{
//		return new DelegatingSecurityContextRepository(new RequestAttributeSecurityContextRepository(), new HttpSessionSecurityContextRepository());
//	}
//	
//	@Bean
//	BCryptPasswordEncoder bCryptPasswordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	AuthenticationManager authManager() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(bCryptPasswordEncoder());
//		return new ProviderManager(authProvider);
//	}
//
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		return http.authorizeHttpRequests()
//				.requestMatchers("/admin/showAddFlight", "/admin/saveFlight", "/addFlight", "/savedflight")
//				.hasRole("ADMIN")
//				.requestMatchers("/findFlights", "/showCompleteReservation*", "/completeReservation", "/reservationConfirmation")
//				.authenticated()
//				.requestMatchers("/showReg", "/login/registerUser" ,"/registerUser", "/login/login", "/login", "/showLogin", "/", "index.html", "/reservations/*")
//				.permitAll().and().csrf().disable()
//				.securityContext((securityContext) -> securityContext.requireExplicitSave(true))
//				.build();
//	}
//}
