package com.ticketbooking.flights.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.flights.entity.Airline;
import com.ticketbooking.flights.entity.Flight;
import com.ticketbooking.flights.exception.FlightNotFoundException;
import com.ticketbooking.flights.repository.AirlineRepository;
import com.ticketbooking.flights.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightrepo;

	@Autowired
	private AirlineRepository airlinerepo;

	public Flight addFlight(int airlineid, Flight flight) throws SQLException, NullPointerException  {

		Optional<Airline> airline = airlinerepo.findById(airlineid);
		
		if (airline.isPresent()) {
			Airline airlinecompany = airline.get();
			flight.setAirline(airlinecompany);
			flight.setAirlineName(airlinecompany.getAirlineName());
			return flightrepo.save(flight);

			}
		else {
			throw new NoSuchElementException("Cannot add flight , No Airlines found for the given airline ID");
		}
		
	}

	public Flight updateFlight(int airlineid, int flightid, Flight flight) throws NullPointerException, SQLException, FlightNotFoundException{
		

		if (flightrepo.existsById(flightid)) {

			if (airlinerepo.existsById(airlineid)) {
				
				Optional<Airline> airline = airlinerepo.findById(airlineid);
				flight.setAirline(airline.get());
				flight.setFlightId(flightid);
				return flightrepo.save(flight);
			}
			else {
				throw new NoSuchElementException("No Airlines found for the given airlineID");
			}

		}
		else {
			throw new FlightNotFoundException("No flights found for the given airlineid");
			
		}

		
	}

	public List<Flight> getFlights(String from, String to, LocalDate date1) {

		return flightrepo.findByInput(from, to, date1);

	}

	public Flight getFlight(int flightid) throws  NullPointerException, SQLException, FlightNotFoundException{
		 Optional<Flight> flightOptional = flightrepo.findById(flightid);
		 if(flightOptional.isPresent()) {
			 return flightOptional.get();
		 }
		 else {
				throw new FlightNotFoundException("No flights found for the given airlineid");
				
			}
	}

	public void updateFlightDataAfterBooking(Flight flight, int flightid) throws SQLException {
		
		if (flightrepo.existsById(flightid)) {
		 flightrepo.save(flight);
		}
		
	}

	public List<Flight> getAllFlights() {
		return flightrepo.findAll();
	}

	public String deleteFlight(int flightid) throws FlightNotFoundException {

		try{
			flightrepo.deleteById(flightid);
			return "Flight Deleted";
		}
		catch(Exception e) {
			throw new FlightNotFoundException("No flights found for the given flightid");
		}
	}

}
