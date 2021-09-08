package com.ticketbooking.booking.exception;

public class TicketDetailsNotFoundException extends Exception {
    
    public TicketDetailsNotFoundException(){
        super();
    }
    public TicketDetailsNotFoundException(String m){
        super(m);
    }
    public TicketDetailsNotFoundException(Exception e){
        super(e);
    }
    public TicketDetailsNotFoundException(String s, Exception e){
        super(s, e);
    }

}