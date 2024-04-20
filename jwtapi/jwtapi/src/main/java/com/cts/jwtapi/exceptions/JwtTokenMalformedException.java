package com.cts.jwtapi.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class JwtTokenMalformedException extends RuntimeException{
	private String message;
	public JwtTokenMalformedException(String message) {
		super(message);
		
	}

}
