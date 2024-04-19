package com.tg.appointmentapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseWrapper<T> {
	
	private String message;
	private T object;
	public ResponseWrapper(T object) {
		super();
		this.message="Appointment Created";
		this.object = object;
	}
	public ResponseWrapper(String message) {
		super();
		this.message = message;
	}
	
	

}
