package com.ticketbooking.flights.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Airline {
	
	
	private String airlineName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int airlineId;
	private String status;
	
	private String airlineEmail;
	
	@OneToMany(mappedBy = "airline")
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
	
	
	public String getAirlineEmail() {
		return airlineEmail;
	}
	public void setAirlineEmail(String airlineEmail) {
		this.airlineEmail = airlineEmail;
	}
	
	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airline(String airlineName, String status, String airlineEmail, List<Flight> flights) {
		super();
		this.airlineName = airlineName;
		this.status = status;
		this.airlineEmail = airlineEmail;
		this.flights = flights;
	}
	@Override
	public String toString() {
		return "Airline [airlineName=" + airlineName + ", airlineId=" + airlineId + ", status=" + status
				+ ", airlineEmail=" + airlineEmail + ", flights=" + flights + "]";
	}
	
	
	

}
