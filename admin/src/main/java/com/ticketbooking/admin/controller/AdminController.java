package com.ticketbooking.admin.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ticketbooking.admin.dto.Airline;
import com.ticketbooking.admin.dto.Flight;
import com.ticketbooking.admin.entity.DiscountCoupon;
import com.ticketbooking.admin.exception.AirlineNotAddedException;
import com.ticketbooking.admin.exception.AirlineNotFoundException;
import com.ticketbooking.admin.exception.DiscountCouponNotFoundException;
import com.ticketbooking.admin.models.Coupon;

import com.ticketbooking.admin.service.AdminService;




@RestController
public class AdminController {
	

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/airline")
	public Airline addAirline(@RequestBody Airline airline) throws NullPointerException, SQLException, AirlineNotAddedException{
		System.out.println(" in add airline");
		HttpHeaders headers = new HttpHeaders();		
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Airline> requestEntity = new HttpEntity<>(airline,headers);
		ResponseEntity<Airline> res = restTemplate.exchange("http://FLIGHT-SERVICE/airline",HttpMethod.POST,requestEntity, new ParameterizedTypeReference<Airline>() {});
		
		if(res.getBody()==null) {
			throw new AirlineNotAddedException("The airline is not added in the table ");
		}
		
		return res.getBody();
	}
	
	@PutMapping("/airline/{airlineid}")
	public Airline blockUnblockAirline(@PathVariable int airlineid) throws NullPointerException, SQLException, AirlineNotFoundException{
		
		ResponseEntity<Airline> res = restTemplate.exchange("http://FLIGHT-SERVICE/airline/"+airlineid,HttpMethod.PUT,null, new ParameterizedTypeReference<Airline>() {});
		
		if(res!=null) return res.getBody();
		else {
			throw new AirlineNotFoundException("Airline not found");
		}
		
		
		
	}
	
	@GetMapping("/airline")
	public List<Airline> getAllAirlines() throws AirlineNotFoundException{
		ResponseEntity<List<Airline>> res = restTemplate.exchange("http://FLIGHT-SERVICE/airline",HttpMethod.GET,null, new ParameterizedTypeReference<List<Airline>>() {});
		
		if(res!=null) return res.getBody();
		else {
			throw new AirlineNotFoundException("Airline not found");
		}
		
	}
	
	
	
	@PostMapping("/airline/{airlineid}/flight")
	public Flight addFlight(@RequestBody  Flight flight, @PathVariable int airlineid) throws NullPointerException{
		System.out.println(" new admin micro service");
		HttpHeaders headers = new HttpHeaders();
		
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Flight> requestEntity = new HttpEntity<>(flight,headers);
		ResponseEntity<Flight> res = restTemplate.exchange("http://FLIGHT-SERVICE/airline/"+airlineid+"/flight",HttpMethod.POST,requestEntity, new ParameterizedTypeReference<Flight>() {});
		
		return res.getBody();

	}
	
	@PutMapping("airline/{airlineid}/flight/{flightid}")
	public Flight updateFlight(@PathVariable int airlineid , @PathVariable int flightid, @RequestBody Flight flight) throws SQLException, NullPointerException, AirlineNotFoundException{
		System.out.println(" admin service");
		
		HttpHeaders headers = new HttpHeaders();
		
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Flight> requestEntity = new HttpEntity<>(flight,headers);
		ResponseEntity<Flight> res = restTemplate.exchange("http://FLIGHT-SERVICE/airline/"+airlineid+"/flight/"+flightid,HttpMethod.PUT,requestEntity, new ParameterizedTypeReference<Flight>() {});
		if(res!=null) return res.getBody();
		else {
			throw new AirlineNotFoundException("Airline not found");
		}

	}
	
	@PostMapping("/coupon")
	public DiscountCoupon addcoupon(@RequestBody Coupon coupon) {
		return adminService.addCoupon(coupon);
		
	}
	
	@PutMapping("/coupon/{couponCode}")
	public DiscountCoupon modifyCoupon(@RequestBody Coupon coupon ,@PathVariable String couponCode) throws DiscountCouponNotFoundException {
		
		return adminService.modifyCoupon(coupon, couponCode);
		
	}
	
	@GetMapping("/coupon/{couponCode}")
	public DiscountCoupon getcoupon(@PathVariable String couponCode) throws DiscountCouponNotFoundException {
		return adminService.getCouponDetails(couponCode);
		
	}
	
    
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
}
