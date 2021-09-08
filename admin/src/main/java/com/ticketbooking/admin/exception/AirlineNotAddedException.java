package com.ticketbooking.admin.exception;

public class AirlineNotAddedException extends Exception{
	
	public AirlineNotAddedException(){
        super();
    }
    public AirlineNotAddedException(String m){
        super(m);
    }
    public AirlineNotAddedException(Exception e){
        super(e);
    }
    public AirlineNotAddedException(String s, Exception e){
        super(s, e);
    }

}
