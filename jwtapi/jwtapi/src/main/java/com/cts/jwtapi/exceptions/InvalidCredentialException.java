package com.cts.jwtapi.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class InvalidCredentialException extends RuntimeException {

	private String message;

	public InvalidCredentialException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
