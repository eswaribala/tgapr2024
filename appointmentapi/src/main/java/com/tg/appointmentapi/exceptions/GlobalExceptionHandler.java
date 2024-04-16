package com.tg.appointmentapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tg.appointmentapi.dtos.ResponseWrapper;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<ResponseWrapper> handlePatientNotFoundException
	(AppointmentNotFoundException exception){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseWrapper(exception.getMessage()));
	}
	
	@ExceptionHandler(AppointmentAlreadyExistsException.class)
	public ResponseEntity<ResponseWrapper> handlePatientAlreadyExistsException(AppointmentAlreadyExistsException exception){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseWrapper(exception.getMessage()));
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseWrapper> handleRuntimeException(RuntimeException exception){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseWrapper(exception.getMessage()));
	}
	
	

}
