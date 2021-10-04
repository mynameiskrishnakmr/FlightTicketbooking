package com.ticketbooking.booking.model;

public class CancelResponse {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CancelResponse(String message) {
		super();
		this.message = message;
	}
	

}
