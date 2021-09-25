package com.ticketbooking.booking.model;

public class CouponResponse {

	
	private String couponStatus;
	
	private double discount;
	
	private double discoutedPrice;

	public String getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(String couponStatus) {
		this.couponStatus = couponStatus;
	}

	public double getDiscoutedPrice() {
		return discoutedPrice;
	}

	public void setDiscoutedPrice(double discoutedPrice) {
		this.discoutedPrice = discoutedPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	

	public CouponResponse(String couponStatus, double discount, double discoutedPrice) {
		super();
		this.couponStatus = couponStatus;
		this.discount = discount;
		this.discoutedPrice = discoutedPrice;
	}

	public CouponResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
