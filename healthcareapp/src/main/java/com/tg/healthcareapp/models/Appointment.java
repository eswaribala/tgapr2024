package com.tg.healthcareapp.models;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	private LocalDate appointmentDate;
	
	@Bean
	//spring object
	public Patient getPateint() {
		//java object
		return new Patient();
	}

}
