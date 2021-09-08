package com.ticketbooking.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	private String userId;
	
	private String password;

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

	public Admin(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
