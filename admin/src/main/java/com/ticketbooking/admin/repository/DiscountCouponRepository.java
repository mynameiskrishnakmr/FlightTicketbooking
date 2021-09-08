package com.ticketbooking.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.admin.entity.DiscountCoupon;



@Repository
public interface DiscountCouponRepository extends JpaRepository<DiscountCoupon, String>{
	
	

}
