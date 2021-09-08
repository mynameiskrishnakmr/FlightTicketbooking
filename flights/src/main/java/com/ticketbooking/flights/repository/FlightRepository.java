package com.ticketbooking.flights.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ticketbooking.flights.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

	@Query("Select f,f.airline.airlineName from Flight f where f.airline.status = 'AVAILABLE' and f.from = ?1 and f.to = ?2 and f.date = ?3")
	List<Flight> findByInput(String from, String to, LocalDate date1);

}
