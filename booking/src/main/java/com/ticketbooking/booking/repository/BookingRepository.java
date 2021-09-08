package com.ticketbooking.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketbooking.booking.entity.BookingDetails;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, Integer>{
	
	@Query("Select b from BookingDetails b where b.user.emailId=?1")
	List<BookingDetails> findByEmail(String emailId);
	
	@Query("Select b from BookingDetails b where b.user.userId = ?1 and b.id = ?2 and  b.status='BOOKED'")
	Optional<BookingDetails> findByIdAndStatus(String userId, int pnr);



}
