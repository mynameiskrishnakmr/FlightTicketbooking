package com.ticketbooking.booking.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ticketbooking.booking.entity.Passenger;
import com.ticketbooking.booking.exception.CancellationNotallowedException;
import com.ticketbooking.booking.exception.NotEnoughSeatsException;
import com.ticketbooking.booking.exception.TicketDetailsNotFoundException;
import com.ticketbooking.booking.model.BookingHistory;
import com.ticketbooking.booking.model.Ticket;
import com.ticketbooking.booking.service.BookingService;

import io.swagger.annotations.ApiOperation;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/users/{userid}/flight/{flightid}")
	@ApiOperation(
			value = "Book a ticket ",
			notes = "if a flightid is invalid or not available exception will be thrown",
			response = Ticket.class
		)
	public Ticket bookTicket(@RequestBody List<Passenger> passengers, @PathVariable int flightid,
			@PathVariable String userid, @RequestParam String discountCoupon) throws SQLException, NotEnoughSeatsException {

		return bookingService.bookTicket(passengers, flightid, userid, discountCoupon);

	}

	@GetMapping("/ticket/{pnr}")
	public Ticket getTicketByPNR(@PathVariable int pnr)
			throws NullPointerException, SQLException, TicketDetailsNotFoundException {
		return bookingService.getTicketByPNR( pnr);
	}

	@GetMapping("/history/{emailId}")
	public List<BookingHistory> getTicketByEmail(@PathVariable String emailId)
			throws SQLException, TicketDetailsNotFoundException {

		return bookingService.getTicketByEmail(emailId);
	}

	@DeleteMapping("/users/{userid}/cancel/{pnr}")
	public void deleteTicketByPNR(@PathVariable String userid, @PathVariable int pnr)
			throws CancellationNotallowedException, TicketDetailsNotFoundException {
		bookingService.deleteTicketByPNR(userid, pnr);

	}

}
