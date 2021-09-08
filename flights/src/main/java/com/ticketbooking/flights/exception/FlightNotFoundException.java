package com.ticketbooking.flights.exception;

public class FlightNotFoundException extends Exception {
	
	 public FlightNotFoundException(){
	        super();
	    }
	    public FlightNotFoundException(String m){
	        super(m);
	    }
	    public FlightNotFoundException(Exception e){
	        super(e);
	    }
	    public FlightNotFoundException(String s, Exception e){
	        super(s, e);
	    }

}