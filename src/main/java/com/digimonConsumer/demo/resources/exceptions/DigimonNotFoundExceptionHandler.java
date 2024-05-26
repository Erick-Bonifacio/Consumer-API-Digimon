package com.digimonConsumer.demo.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.digimonConsumer.demo.services.exceptions.DigimonNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DigimonNotFoundExceptionHandler {
	
	@ExceptionHandler(DigimonNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(DigimonNotFoundException e, HttpServletRequest request){
		String error = "Resource Not Found!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
