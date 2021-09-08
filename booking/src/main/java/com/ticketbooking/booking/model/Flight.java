package com.ticketbooking.booking.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
	
	private int flightId;
	
	private Airline airline;
		
	private String airlineName;
	
	private String flightName;
		
	private String from;
	
	private String to;
		
	private LocalTime dateTime;
		
	private LocalDate date;
	
	private int price;
	
	private int seats;
	
	private int seatsBooked;
	

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public LocalTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalTime dateTime) {
		this.dateTime = dateTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getFlightId() {
		return flightId;
	}
	
	
	

	public Flight(String airlineName, String flightName, String from, String to, LocalTime dateTime, LocalDate date,
			int price, int seats, int seatsBooked ) {
		super();
		this.airlineName = airlineName;
		this.flightName = flightName;
		this.from = from;
		this.to = to;
		this.dateTime = dateTime;
		this.date = date;
		this.price = price;
		this.seats = seats;
		this.seatsBooked = seatsBooked;
		
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlineName=" + airlineName + ", flightName=" + flightName
				+ ", from=" + from + ", to=" + to + ", dateTime=" + dateTime + ", date=" + date + ", price=" + price
				+ "]";
	}


	
	

}


