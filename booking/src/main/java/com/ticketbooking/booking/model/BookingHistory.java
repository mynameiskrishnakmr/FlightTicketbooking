package com.ticketbooking.booking.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class BookingHistory {
	
	
	private String userId;
	
	private String userEmail;
	
	private String airlineName;
	
	private String flightFrom;
	
	private String flightTo;
	
	private LocalDate flightDate;
	
	private LocalTime flightTime;
	
	private int noOfPassengers;
	
	private List<PassengerDetails> passengers;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFlightFrom() {
		return flightFrom;
	}

	public void setFlightFrom(String flightFrom) {
		this.flightFrom = flightFrom;
	}

	public String getFlightTo() {
		return flightTo;
	}

	public void setFlightTo(String flightTo) {
		this.flightTo = flightTo;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public List<PassengerDetails> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<PassengerDetails> passengers) {
		this.passengers = passengers;
	}

	public BookingHistory(String userId, String userEmail, String airlineName, String flightFrom, String flightTo,
			LocalDate flightDate, LocalTime flightTime, int noOfPassengers, List<PassengerDetails> passengers) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.airlineName = airlineName;
		this.flightFrom = flightFrom;
		this.flightTo = flightTo;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.noOfPassengers = noOfPassengers;
		this.passengers = passengers;
	}

	public BookingHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	

}
