# SpringBootAndAngularProject_FlightReservationAndCheckin
Flight Reservation and CheckIn Project created using SpringBoot and additional CheckIn project created using Angular.
Made with help of Udemy course: Project Development Using Spring Boot by Bharath Thippireddy.

# MySQL Database
Before starting any of the below mentioned apps, start MySQL, create reservation database and all the required tables. For table creation, refer to sql files present in SQL folder of project to create flight, user, passenger, reservation, role, user_role tables.

# SpringBoot Applications:
Two microservices flightreservation and flightcheckin communicate with each other using Integration layer. FLightCheckIn app uses ReservationRestClientImpl class to converse with ReservationRestController class of FlightReservation app. FlightCheckIn app needs id from flightreservation as well as wants to update number of bags in flight reservation for which it uses Integration Layer and REST protocols. 

# 1. Flight Reservation: (runs on port 8080)
   -Click flightreservation and run as SpringBoot App and enter http://localhost:8080/flightreservation/ in browser to land on home page of app.<br/>
   -1st, register a user using register button. After registering, login with same user<br/>
   -Enter the flight departure city, arrival city and date of departure from the data populated in flight table.(Enter From: AUS, To: NYC, Date: 02-05-2018)<br/>
   -From all flights, select any 1 flight to register the user as passenger n make flight reservation. Enter all reservation details, click on submit to submit reservation.<br/>

To generate flights data: Either copy paste all data present in AddFlights.sql or in flightreservation app, click on add flights to add flight data.<br/>

ReservationPDFGeneration in Utility layer: Once reservation is made in flightreservation, a reservation pdf will be generated for it on path: /Users/I534875/Documents/SpringFramework_In_Easy_Steps/FlightReservation/pdf_itineraries_of_reservations/reservation as specified in application.properties. When user submits a reservation, bookFlight method of ReservationServiceImpl class is invoked which saves the pdf at given path using PDFGenerator.java.

# 2. Flight Checkin: (runs on port 9090)
   -Click flightcheckin and run as SpringBoot App and enter http://localhost:8080/flightcheckin/ in browser to land on home page of app.<br/>
   -Enter the registation id of the registration for which you want to checkin. Afterwards, add number of bags and click on CheckIn.  <br/>

# Angular Application:
Instead of using springboot flightcheckin app, we can also use angular flightcheckin app for checkin to illustrate effective client-sever model.<br/>
# 1. Flight Checkin: (runs on port 4200)
   -After downloading flightCheckIn, run 'npm i' to create node_modules and package-lock.json file. Then enter 'ng serve -o' to start app on http://localhost:4200<br/>
   -Click on start, then enter registration id for which checkin needs to be performed. Enter number of bags and click ChekcIn to submit reservation<br/>




# Technology used:
-Used sping mvc to create web projects flightreservation n flightcheckin apps. <br/>
-Used spring data jpa to bind database tables with java entity objects. <br/>
-flightreservation and flightcheckin communicate with each other using Integration layer and REST protocols as stated above.<br/>
-We did not implement spring security in this app.<br/>
-We have enabled logging throughout the application and set the root level to info in the flightreservation->src/main/resources->logback.xml. Refer this logback.xml for all logging configuration. In case if it slows the application, remove it. You can also use commented code in application.properties for login.<br/>
-All the controllers can be referred to flightreservation app flow, starting from UserController where home page url request mapping is specified.<br/>
-index.html serves as our home page for springboot apps.<br/>
-CorsConfig is configured to allow all incoming requests from angular client.<br/>
-Various jsps are served to render all springBoot UI.<br/>

# Common error:
FLightReservation app may throw error database when it starts. To remove it, in application.properties, erase dataSource and type it again.
