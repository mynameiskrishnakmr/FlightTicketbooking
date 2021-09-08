package com.ticketbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.booking.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
