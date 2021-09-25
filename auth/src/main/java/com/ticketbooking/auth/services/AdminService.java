package com.ticketbooking.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.auth.entity.Admin;
import com.ticketbooking.auth.repository.AdminRepository;


@Service
public class AdminService {

	
	@Autowired
	private AdminRepository adminrepo;
	
	public Admin register(Admin admin) {
		System.out.println("In user service");
		return adminrepo.save(admin);
	}

	
	
}
