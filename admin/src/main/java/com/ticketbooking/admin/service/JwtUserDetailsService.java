package com.ticketbooking.admin.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ticketbooking.admin.entity.Admin;
import com.ticketbooking.admin.repository.AdminRepository;



@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<Admin> userIdOptional = adminrepo.findById(username);
		System.out.println("userId from DB" +userIdOptional.get().getUserId());
		System.out.println("Pwd from DB" +userIdOptional.get().getPassword());
		System.out.println("input user name" +username);
		String userId = userIdOptional.get().getUserId();
		if (userId.equals(username)) {
            
			return new User(userId, new BCryptPasswordEncoder().encode(userIdOptional.get().getPassword()), new ArrayList<>());
	} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

	}
}