package com.madhu.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ExpenseException.class)
	public ResponseEntity<MyErrorDetails> expenseExceptionHandler(ExpenseException ex, WebRequest req) {

		var me = new MyErrorDetails();

		me.setTimestamp(LocalDateTime.now());
		me.setMessage(ex.getMessage());
		me.setDescription(req.getDescription(false));

		return new ResponseEntity<>(me, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DestinationException.class)
	public ResponseEntity<MyErrorDetails> destinationExceptionHandler(DestinationException ex, WebRequest req) {

		var me = new MyErrorDetails();

		me.setTimestamp(LocalDateTime.now());
		me.setMessage(ex.getMessage());
		me.setDescription(req.getDescription(false));

		return new ResponseEntity<>(me, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ItineraryException.class)
	public ResponseEntity<MyErrorDetails> itineraryExceptionHandler(ItineraryException ex, WebRequest req) {

		var me = new MyErrorDetails();

		me.setTimestamp(LocalDateTime.now());
		me.setMessage(ex.getMessage());
		me.setDescription(req.getDescription(false));

		return new ResponseEntity<>(me, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception ex, WebRequest req) {

		var me = new MyErrorDetails();

		me.setTimestamp(LocalDateTime.now());
		me.setMessage(ex.getMessage());
		me.setDescription(req.getDescription(false));

		return new ResponseEntity<>(me, HttpStatus.BAD_REQUEST);
	}

}
