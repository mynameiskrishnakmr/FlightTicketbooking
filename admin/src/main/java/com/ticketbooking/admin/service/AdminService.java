package com.ticketbooking.admin.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.admin.entity.Admin;
import com.ticketbooking.admin.entity.DiscountCoupon;
import com.ticketbooking.admin.exception.DiscountCouponNotFoundException;
import com.ticketbooking.admin.models.Coupon;
import com.ticketbooking.admin.repository.AdminRepository;
import com.ticketbooking.admin.repository.DiscountCouponRepository;


@Service
public class AdminService {
	
	@Autowired
	private DiscountCouponRepository discountcouponrepo; 
	
	@Autowired
	private AdminRepository adminrepo;

	public DiscountCoupon addCoupon(Coupon coupon) {
		DiscountCoupon disCoup = new DiscountCoupon(coupon.getCouponCode(),coupon.getExpiryDate(),coupon.getStatus(),coupon.getDiscountPrice());
		return discountcouponrepo.save(disCoup);
	}

	public DiscountCoupon modifyCoupon(Coupon coupon, String couponCode) throws DiscountCouponNotFoundException {

		Optional<DiscountCoupon> couponDet = discountcouponrepo.findById(couponCode);
		if(couponDet.isPresent()) {
			DiscountCoupon disCoup = new DiscountCoupon(coupon.getCouponCode(),coupon.getExpiryDate(),coupon.getStatus(),coupon.getDiscountPrice());
			discountcouponrepo.save(disCoup);
			return disCoup;
		}
		else
			throw new DiscountCouponNotFoundException("Coupon is not available for the given coupon code" + couponCode);
		
		
	}

	public DiscountCoupon getCouponDetails(String couponCode) throws DiscountCouponNotFoundException {

		 Optional<DiscountCoupon> couponDetails = discountcouponrepo.findById(couponCode);
		 
		 if(couponDetails.isPresent()) {
			 return couponDetails.get();
		 }
		 else {
			 throw new DiscountCouponNotFoundException("No coupon is present" + couponCode);
		 }
	}
	
	public List<DiscountCoupon> getAllCoupon(){
		
		return discountcouponrepo.findAll();
	}

	public String deleteCouponDetails(String couponCode) throws DiscountCouponNotFoundException {

		 try{
			 discountcouponrepo.deleteById(couponCode);
		 }
		 catch(Exception e){
			 throw new DiscountCouponNotFoundException("No coupon is present" + couponCode);
		 }
		 
		 return "Coupon Deleted";
	}

	public Admin register(Admin admin) {
		System.out.println("In user service");
		if(!adminrepo.existsById(admin.getUserId())) {
			return adminrepo.save(admin);
		}
		else {
			throw new NoSuchElementException("User Id exists already");
		}
		
		 
		 
		
		
		
	}

}
