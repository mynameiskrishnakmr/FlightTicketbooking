package com.ticketbooking.booking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class User {
	
	private String firstName;
	
	private String lastName;
	
	
	@Id
	private String userId;
	
	private String gender;
	
	private int age;
	
	@NonNull
	private String emailId;
	
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "USER_FLIGHT_BOOKING", joinColumns = @JoinColumn(name =
	 * "USER_ID"), inverseJoinColumns = @JoinColumn(name = "FLIGHT_ID")) private
	 * List<Flight> flight;
	 */
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	

	public String getUserId() {
		return userId;
	}

	public User(String firstName, String lastName, String gender, int age, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.emailId = emailId;
		//this.flight = flight;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/*
	 * public List<Flight> getFlight() { return flight; }
	 * 
	 * public void setFlight(List<Flight> flight) { this.flight = flight; }
	 */

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userId=" + userId + ", gender=" + gender
				+ ", age=" + age + ", emailId=" + emailId + "]";
	}
	
	
	
	

}
