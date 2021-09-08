package com.ticketbooking.booking.exception;

public class NotEnoughSeatsException extends Exception {
    
    public NotEnoughSeatsException(){
        super();
    }
    public NotEnoughSeatsException(String m){
        super(m);
    }
    public NotEnoughSeatsException(Exception e){
        super(e);
    }
    public NotEnoughSeatsException(String s, Exception e){
        super(s, e);
    }

}