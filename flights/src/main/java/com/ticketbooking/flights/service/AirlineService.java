package com.ticketbooking.flights.service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.flights.entity.Airline;
import com.ticketbooking.flights.repository.AirlineRepository;

@Service
public class AirlineService {

	@Autowired
	private AirlineRepository airlinerepo;
	
	
	
   private final String AIRLINE_AVAILABLE = "AVAILABLE";
	private final String AIRLINE_BLOCKED = "BLOCKED";
	
	public Airline addAirline(Airline airline) throws SQLException,NullPointerException{
		
		airline.setStatus(AIRLINE_AVAILABLE);
		return airlinerepo.save(airline);
		
	}

	public Airline blockairline(int airlineId) throws NoSuchElementException {
		
		
		Optional<Airline> airline = airlinerepo.findById(airlineId);
		if(airline.isPresent()) {
			 Airline blockUnblockAirline = airline.get();
			 if(blockUnblockAirline.getStatus().equalsIgnoreCase(AIRLINE_AVAILABLE))
				 blockUnblockAirline.setStatus(AIRLINE_BLOCKED);
			 else 
				 blockUnblockAirline.setStatus(AIRLINE_AVAILABLE);
			return airlinerepo.save(blockUnblockAirline);
		}
		
		throw new NoSuchElementException("No Airlines found for the given airlineID");
		
	}

	public List<Airline> getAllAirlines() throws SQLException,NullPointerException, NoSuchElementException {

		return airlinerepo.findAll();
	}


}
