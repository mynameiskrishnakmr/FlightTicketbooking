package com.ticketbooking.admin.exception;

public class AirlineNotFoundException extends Exception {
    
    public AirlineNotFoundException(){
        super();
    }
    public AirlineNotFoundException(String m){
        super(m);
    }
    public AirlineNotFoundException(Exception e){
        super(e);
    }
    public AirlineNotFoundException(String s, Exception e){
        super(s, e);
    }

}