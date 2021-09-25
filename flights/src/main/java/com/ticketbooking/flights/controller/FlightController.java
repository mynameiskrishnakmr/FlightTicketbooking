package com.ticketbooking.flights.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.flights.entity.Flight;
import com.ticketbooking.flights.exception.FlightNotFoundException;
import com.ticketbooking.flights.service.FlightService;

@RestController

public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping(path = "airline/{id}/flight", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Flight addFlight(@PathVariable int id, @RequestBody Flight flight) throws SQLException, NoSuchElementException {
		
	    
		return flightService.addFlight(id,flight);

	}

	@PutMapping("airline/{id}/flight/{flightid}")
	//@CachePut(key = "#flightid", value = "flightList")
	public Flight updateFlight(@PathVariable int id , @PathVariable int flightid, @RequestBody Flight flight) throws NullPointerException, SQLException, NoSuchElementException, FlightNotFoundException {
		
	    
		return flightService.updateFlight(id ,flightid,flight);

	}
	
	@GetMapping("flight/{flightid}")
//	@Cacheable(key = "#flightid", value = "flightList")
	public Flight getFlight(@PathVariable int flightid) throws NoSuchElementException,NullPointerException, SQLException, FlightNotFoundException {
		
	    
		return flightService.getFlight(flightid);

	}
	


	@GetMapping("search")
	//@Cacheable(value = "flightList")
	public List<Flight> getFlights(@RequestParam String from , @RequestParam String to, @RequestParam String date) throws ParseException, FlightNotFoundException, NoSuchElementException{
		
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		  
		  LocalDate date1 = LocalDate.parse(date, dtf);
		 
		  if(flightService.getFlights(from,to,date1)!=null) {
			  
			  return flightService.getFlights(from,to,date1);
		  }
		  
		  else {
			  throw new FlightNotFoundException("No flights found for the given search details");
		  }
	
		
	}
	
	
	@GetMapping("/all")
	
	public List<Flight> getAllFlights() throws ParseException, FlightNotFoundException, NoSuchElementException{
		
		System.out.println("flightService.getAllflights----"+flightService.getAllFlights());
			return flightService.getAllFlights()!=null? flightService.getAllFlights():  null;
		  
	
		
	}

	@DeleteMapping("airline/{id}/flight/{flightid}")
	public String deleteFlight(@PathVariable int flightid) throws FlightNotFoundException {
		
		return flightService.deleteFlight(flightid);
	}
}
