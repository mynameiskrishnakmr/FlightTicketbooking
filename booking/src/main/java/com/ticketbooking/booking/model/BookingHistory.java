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
	
	private int pnr;
	
	private int flightId;
	
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
	
	

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public BookingHistory(String userId, String userEmail, String airlineName, String flightFrom, String flightTo,
			LocalDate flightDate, LocalTime flightTime, int noOfPassengers, List<PassengerDetails> passengers, int pnr, int flightId) {
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
		this.pnr=pnr;
		this.flightId=flightId;
	}

	public BookingHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	

}
