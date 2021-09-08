package com.ticketbooking.admin.exception;

public class DiscountCouponNotFoundException extends Exception{

	
	public DiscountCouponNotFoundException(){
        super();
    }
    public DiscountCouponNotFoundException(String m){
        super(m);
    }
    public DiscountCouponNotFoundException(Exception e){
        super(e);
    }
    public DiscountCouponNotFoundException(String s, Exception e){
        super(s, e);
    }
}
