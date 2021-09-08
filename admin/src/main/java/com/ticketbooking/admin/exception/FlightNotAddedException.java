package com.ticketbooking.admin.exception;

public class FlightNotAddedException extends Exception {
	
	 public FlightNotAddedException(){
	        super();
	    }
	    public FlightNotAddedException(String m){
	        super(m);
	    }
	    public FlightNotAddedException(Exception e){
	        super(e);
	    }
	    public FlightNotAddedException(String s, Exception e){
	        super(s, e);
	    }

}
