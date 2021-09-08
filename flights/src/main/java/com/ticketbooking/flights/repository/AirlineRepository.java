package com.ticketbooking.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.flights.entity.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline , Integer>{

}
