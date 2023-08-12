<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Flight:</title>
</head>
<body>
<h2>Add Flight:</h2>
<form action="saveFlight" method="post">
<pre>
	Flight_number: 			  <input type="text" name="flightNumber"/><br />
	Operating_airlines: 	  <input type="text" name="operatingAirlines"/><br />
	Departure City: 		  <input type="text" name="departureCity"/><br />
	Arrival City:			  <input type="text" name="arrivalCity"/><br />
	Date Of Departure:  	  <input type="date" name="dateOfDeparture"/><br /> 
	Estimated Departure Time: <input type="time" name="estimatedDepartureTime"/><br /> 
	<input type="submit" value="save">
</pre>
</form>


<br/><br/>
<button><a href="/flightreservation">Go To Home Page</a></button>

</body>
</html>