package com.ticketbooking.flights.advice;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ticketbooking.flights.exception.FlightNotFoundException;
import com.ticketbooking.flights.models.ErrorResponseMessage;

@ControllerAdvice
public class FlightsControllerAdvice {
	
	@ExceptionHandler(FlightNotFoundException.class)
	 public ResponseEntity<ErrorResponseMessage> handleFlightNotFound(Exception e){
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
