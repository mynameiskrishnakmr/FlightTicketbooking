package com.ticketbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.booking.entity.Passenger;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
