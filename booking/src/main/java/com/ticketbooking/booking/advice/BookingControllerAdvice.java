package com.ticketbooking.booking.advice;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ticketbooking.booking.exception.CancellationNotallowedException;
import com.ticketbooking.booking.exception.NotEnoughSeatsException;
import com.ticketbooking.booking.exception.TicketDetailsNotFoundException;
import com.ticketbooking.booking.model.ErrorResponseMessage;

@ControllerAdvice

public class BookingControllerAdvice {

	
	@ExceptionHandler(CancellationNotallowedException.class)
	 public ResponseEntity<ErrorResponseMessage> handleCancellationNotallowedlException(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }
	
	@ExceptionHandler(NotEnoughSeatsException.class)
	 public ResponseEntity<ErrorResponseMessage> handlNotEnoughSeatsAvailableException(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }
	
	
	@ExceptionHandler(TicketDetailsNotFoundException.class)
	 public ResponseEntity<ErrorResponseMessage> TicketDetailsNotFoundException(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }
	
	@ExceptionHandler(SQLException.class)
	 public ResponseEntity<ErrorResponseMessage> handleSqlException(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }
	
	@ExceptionHandler(NullPointerException.class)
	 public ResponseEntity<ErrorResponseMessage> handlNullPointerException(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }
	@ExceptionHandler(NoSuchElementException.class)
	 public ResponseEntity<ErrorResponseMessage> handlNoSuchelementException(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }
	
}
