package com.ticketbooking.admin.dto;
public class StringResponse {

    private String response;

    public StringResponse(String s) { 
       this.response = s;
    }
    
    public StringResponse() {
    	
    }

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
    
    
   
}