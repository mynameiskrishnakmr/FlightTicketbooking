package com.ticketbooking.admin.advice;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ticketbooking.admin.exception.AirlineNotAddedException;
import com.ticketbooking.admin.exception.AirlineNotFoundException;
import com.ticketbooking.admin.exception.FlightNotAddedException;
import com.ticketbooking.admin.exception.FlightNotFoundException;
import com.ticketbooking.admin.models.ErrorResponseMessage;



@ControllerAdvice
public class AdminControllerAdvice {
	
	 @ExceptionHandler(AirlineNotFoundException.class)
	 public ResponseEntity<ErrorResponseMessage> handleAirlineNotFound(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }

	 @ExceptionHandler(AirlineNotAddedException.class)
	 public ResponseEntity<ErrorResponseMessage> handleAirlineNotAddedException(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }
	 
	 @ExceptionHandler(FlightNotFoundException.class)
	 public ResponseEntity<ErrorResponseMessage> handleFlightNotFound(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }
	 
	 @ExceptionHandler(NoSuchElementException.class)
	 public ResponseEntity<ErrorResponseMessage> handleNosuchelementException(Exception e){
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
	
	
	@ExceptionHandler(FlightNotAddedException.class)
	 public ResponseEntity<ErrorResponseMessage> handleFlightNotAddedException(Exception e){
		 return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponseMessage(500, e.getMessage(), e));
	 }
}
