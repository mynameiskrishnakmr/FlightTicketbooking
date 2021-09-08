package com.ticketbooking.booking.exception;

public class CancellationNotallowedException extends Exception {
    
    public CancellationNotallowedException(){
        super();
    }
    public CancellationNotallowedException(String m){
        super(m);
    }
    public CancellationNotallowedException(Exception e){
        super(e);
    }
    public CancellationNotallowedException(String s, Exception e){
        super(s, e);
    }

}