package com.tg.healthcareapp.models;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.tg.healthcareapp.facades.DataSource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	private LocalDate appointmentDate;
    @Autowired
	private DataSource dataSource;
	@Bean
	@Lazy
	//spring object
	public Patient getPateint() {
		dataSource.addData("Patient Created");
		//java object
		return new Patient();
	}

}
