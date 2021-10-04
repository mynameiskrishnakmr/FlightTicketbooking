package com.ticketbooking.admin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private String userId;
	
	private String firstName;
	
	private String lastname;
	
	
	
	
	
	private String password;
	
	private String gender;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Admin(String userId, String firstName, String lastname, String emailId, String password, String gender) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastname = lastname;
		
		this.password = password;
		this.gender = gender;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastname=" + lastname 
				+ ", password=" + password + ", gender=" + gender + "]";
	}
}