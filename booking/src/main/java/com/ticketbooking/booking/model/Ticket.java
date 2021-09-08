package com.ticketbooking.booking.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;



public class Ticket {

	private String UserId;
	
	private String flightName;
	
	private LocalDate flightdate;
	
	private LocalTime flightTime;
	
	private int pnr;
	
	private String airLine;
	
	private String status;
	
	private double price;
	
	private Set<PassengerDetails> passengers;
	
	private String couponApplied;

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public LocalDate getFlightdate() {
		return flightdate;
	}

	public void setFlightdate(LocalDate flightdate) {
		this.flightdate = flightdate;
	}

	public String getAirLine() {
		return airLine;
	}

	public void setAirLine(String airLine) {
		this.airLine = airLine;
	}

	public Set<PassengerDetails> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<PassengerDetails> passengers) {
		this.passengers = passengers;
	}

	
	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public String getCouponApplied() {
		return couponApplied;
	}

	public void setCouponApplied(String couponApplied) {
		this.couponApplied = couponApplied;
	}

	public Ticket(String userId, String flightName, LocalDate flightdate,LocalTime flightTime, String airLine, int pnr, Set<PassengerDetails> passengers, String status, double price ,String couponApplied) {
		super();
		UserId = userId;
		this.flightName = flightName;
		this.flightdate = flightdate;
		this.airLine = airLine;
		this.passengers = passengers;
		this.flightTime = flightTime;
		this.pnr = pnr;
		this.status=status;
		this.price = price;
		this.couponApplied=couponApplied;
	}


	public Ticket(String userId, String flightName, LocalDate flightdate,LocalTime flightTime, String airLine, int pnr, Set<PassengerDetails> passengers, String status, double price ) {
		super();
		UserId = userId;
		this.flightName = flightName;
		this.flightdate = flightdate;
		this.airLine = airLine;
		this.passengers = passengers;
		this.flightTime = flightTime;
		this.pnr = pnr;
		this.status=status;
		this.price = price;
		
	}
	

	@Override
	public String toString() {
		return "Ticket [UserId=" + UserId + ", flightName=" + flightName + ", flightdate=" + flightdate
				+ ", flightTime=" + flightTime + ", pnr=" + pnr + ", airLine=" + airLine + "]";
	}
	
	
	
}


