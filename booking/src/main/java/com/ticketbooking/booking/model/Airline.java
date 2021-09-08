package com.ticketbooking.booking.model;

import java.util.List;

public class Airline {
	
	private String airlineName;
	private int airlineId;
	private String status;
	
	
	private List<Flight> flights;
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public int getAirlineId() {
		return airlineId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Airline(String airlineName, String status) {
		super();
		this.airlineName = airlineName;
		this.status = status;
	}
	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Airline [airlineName=" + airlineName + ", airlineId=" + airlineId + ", status=" + status + "]";
	}
	
	

}
