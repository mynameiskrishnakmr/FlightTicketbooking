package com.ticketbooking.flights.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	
	private static final String TOPIC ="airline";
	
	/*@PostMapping("/airline")
	public Airline addAirline(@RequestBody Airline airline) throws NullPointerException, SQLException {
		
		
		System.out.println("Airline" +airline.toString() );
		
		return airlineService.addAirline(airline);
		
	}*/
	
	
	@KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
	public Airline addAirline(com.ticketbooking.admin.dto.Airline airline) throws NullPointerException, SQLException {
		
		Airline airlineEntity = airline.getAirlineEntity();
		System.out.println("Airline" +airline.toString() );
		
		return airlineService.addAirline(airlineEntity);
		
		//return null;
		
	}
	
	@PutMapping("/airline/{id}")
	//@CachePut(key = "#id", value = "airlineList")
	public Airline blockAirline(@PathVariable int id) {
		
		return airlineService.blockairline(id);
	}
	
	/*@KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void blockAirline(Integer airlineId) {
        System.out.println("airline id: " + airlineId);
    }*/
	 
	
	@GetMapping("/airline")
	//@Cacheable(value = "airlineList")
	public List<Airline> getAllAirlines() throws NullPointerException, NoSuchElementException, SQLException{
		
		
		return airlineService.getAllAirlines();
		
	}
	

}
