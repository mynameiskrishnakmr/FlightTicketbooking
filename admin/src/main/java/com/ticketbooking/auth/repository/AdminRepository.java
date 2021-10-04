package com.ticketbooking.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketbooking.auth.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

	@Query("Select a.userId from Admin a where a.userId= ?1")
	Optional<String> findUserId(String username);

}
