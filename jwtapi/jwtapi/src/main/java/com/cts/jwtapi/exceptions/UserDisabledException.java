package com.cts.jwtapi.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDisabledException extends RuntimeException {

	private String message;

	public UserDisabledException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
