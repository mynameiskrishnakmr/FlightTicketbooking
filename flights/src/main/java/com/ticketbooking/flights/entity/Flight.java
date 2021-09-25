package com.ticketbooking.flights.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;  
@Entity
public class Flight {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "FLIGHT_ID")
	private int flightId;
	
	@ManyToOne
	@JoinColumn(name = "AIRLINE_ID")
	private Airline airline;

	@Column(name = "AIRLINE_NAME")
	private String airlineName;
	
	@Column(name = "FLIGHT_NAME")
	private String flightName;
	
	@Column(name = "FLIGHT_FROM")
	private String from;
	
	@Column(name = "FLIGHT_TO")
	private String to;
	
	@Column(name = "FLIGHT_TIME")
	private LocalTime dateTime;
	
	@Column(name = "FLIGHT_DATE")
	private LocalDate date;
	
	@Column(name = "FLIGHT_PRICE")
	private int price;
	
	@Column(name = "TOTAL_NUMBER_OF_SEATS")
	private int seats;
	
	@Column(name = "SEATS_BOOKED")
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
	
	
	

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public Flight(String airlineName, String flightName, String from, String to, LocalTime dateTime, LocalDate date,
			int price, int seats, int seatsBooked ) {
		super();
		
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
		return "Flight [flightId=" + flightId + ", flightName=" + flightName
				+ ", from=" + from + ", to=" + to + ", dateTime=" + dateTime + ", date=" + date + ", price=" + price
				+ "]";
	}


	
	

}
