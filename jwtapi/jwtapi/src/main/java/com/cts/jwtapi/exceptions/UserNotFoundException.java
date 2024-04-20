package com.cts.jwtapi.exceptions;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserNotFoundException extends RuntimeException{
  
	private String message;
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
