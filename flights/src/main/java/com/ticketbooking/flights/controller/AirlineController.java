package com.ticketbooking.flights.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.flights.entity.Airline;
import com.ticketbooking.flights.service.AirlineService;


@RestController
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	
	@PostMapping("/airline")
	public Airline addAirline(@RequestBody Airline airline) throws NullPointerException, SQLException {
		
		
		System.out.println("Airline" +airline.toString() );
		
		return airlineService.addAirline(airline);
		
	}
	
	@PutMapping("/airline/{id}")
	public Airline blockAirline(@PathVariable int id) {
		
		return airlineService.blockairline(id);
	}
	
	@GetMapping("/airline")
	public List<Airline> getAllAirlines() throws NullPointerException, NoSuchElementException, SQLException{
		
		
		return airlineService.getAllAirlines();
		
	}
	

}
