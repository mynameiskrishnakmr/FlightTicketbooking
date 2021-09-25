package com.ticketbooking.flights;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.ticketbooking.flights.entity.Airline;
import com.ticketbooking.flights.entity.Flight;
import com.ticketbooking.flights.repository.AirlineRepository;
import com.ticketbooking.flights.repository.FlightRepository;
import com.ticketbooking.flights.service.AirlineService;
import com.ticketbooking.flights.service.FlightService;

@SpringBootTest
class FlightsApplicationTests {

	@Autowired
	public AirlineService service;
	
	@Autowired
	public FlightService flightService;
	
	@MockBean
	public AirlineRepository repo;
	
	@MockBean
	public FlightRepository flightrepo;
	
	
	 @Test
	    public void testAllAirlines_1() throws NullPointerException, NoSuchElementException, SQLException{

	        Mockito.when(repo.findAll()).thenReturn(new ArrayList<Airline>());

	        List<Airline> books =  service.getAllAirlines();

	        System.out.println(books);

	        Assertions.assertSame(0, books.size());
	    }
	 
	 @Test
	    public void testAllAirlines_2() throws NullPointerException, NoSuchElementException, SQLException{
		 	
		  List<Airline> airlines = new ArrayList<>();
		  Airline airline1 = new Airline("abc","AVAILABLE","SDS@GMAIL.COM",null);
		  Airline airline2 = new Airline("def","AVAILABLE","SDS@GMAIL.COM",null);
		  airlines.add(airline1);
		  airlines.add(airline2);
	        Mockito.when(repo.findAll()).thenReturn(airlines);

	        List<Airline> a =  service.getAllAirlines();

	        System.out.println(a);

	        Assertions.assertSame(2, a.size());
	    }
	 
	 
	 @Test
	    public void testAllFlights_1() throws NullPointerException, NoSuchElementException, SQLException{

		 	String from="IND",to="NYC";

			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
			  
			  LocalDate date = LocalDate.parse("2021-09-30", dtf);
		 	
			  List<Flight> flights = new ArrayList<Flight>();
			  flights.add(new  Flight("ABC", "ba", "IND","nyc", null, LocalDate.parse("2021-09-30", dtf) , 4000, 300, 31));
			  
			  Mockito.when(flightrepo.findByInput(from, to, date)).thenReturn(flights);
			  
	        

	        List<Flight> f =  flightService.getFlights(from, to, date);

	        System.out.println("flights get"+f.toString());
	        
	        Assertions.assertNotNull(f);
	        Assertions.assertEquals("ba", f.get(0).getFlightName());

	        
	    }
	 
	 
	 
	 
	
}
