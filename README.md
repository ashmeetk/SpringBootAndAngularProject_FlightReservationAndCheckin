# SpringBootAndAngularProject_FlightReservationAndCheckin
Flight Reservation and CheckIn Project created using SpringBoot and additional CheckIn project created using Angular.

SpringBoot Applications:
Two microservices flightreservation and flightcheckin communicate with each other using Integration layer. FLightCheckIn app uses ReservationRestClientImpl class to converse with ReservationRestController class of FlightReservation app. FlightCheckIn app needs id from flightreservation as well as wants to update number of bags in flight reservation for which it uses Integration Layer and REST protocols. 

1. Flight Reservation: (runs on port 8080)
   -Click flightreservation and run as SpringBoot App and enter http://localhost:8080/flightreservation/ in browser to land on home page of app.
   -First register a user using register button. After registering, login with same user
   -Enter the flight departure city, arrival city and date of departure from the data populated in flight table.(will tell about it in tables section. For now, enter From: AUS, To: NYC, Depature Date: 02-05-2018)
   -From all flights, select any 1 flight to register the user as passenger n make flight reservation. After entering all reservation details, click on submit to submit reservation.
   -

3. Flight Checkin: (runs on port 9090)
   -Click flightcheckin and run as SpringBoot App and enter http://localhost:8080/flightcheckin/ in browser to land on home page of app.
   -Enter the registation id of the registration for which you want to checkin. Afterwards, add number of bags and click on CheckIn.
   -

Angular Application:
Instead of using springboot flightcheckin app, we can also use angular flightcheckin app for checkin to illustrate effective client-sever model.
1. Flight Checkin: (runs on port 4200)
   -After downloading flightCheckIn, run 'npm i' to create node_modules and package-lock.json file. Then enter 'ng serve -o' to start app on http://localhost:4200
   -Click on start, then enter registration id for which checkin needs to be performed. Enter number of bags and click ChekcIn to submit reservation.
   -
