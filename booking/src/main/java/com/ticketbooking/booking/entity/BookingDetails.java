package com.ticketbooking.booking.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pnr")
	private int id;
	
	@Column(name = "FLIGHT_ID")
	private int flight;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private String status;
	
	
	private double price;
	
	@OneToMany(mappedBy = "bookings" , fetch = FetchType.EAGER)
	private List<Passenger> passengers;

	
	
	public int getId() {
		return id;
	}

	public int getFlight() {
		return flight;
	}

	public void setFlight(int flight) {
		this.flight = flight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
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

public BookingDetails(int flight, User user, String status, double price, List<Passenger> passengers) {
		super();
		this.flight = flight;
		this.user = user;
		this.status = status;
		this.price = price;
		this.passengers = passengers;
	}

public BookingDetails() {
	
}

@Override
public String toString() {
	return "BookingDetails [id=" + id + ", flight=" + flight + ", user=" + user + ", passengers=" + passengers + "]";
}



}
