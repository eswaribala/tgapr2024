package com.cts.jwtapi.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class JWTMissingTokenException extends RuntimeException{
	private String message;
	public JWTMissingTokenException(String message) {
		super(message);
		
	}
}
