package com.tg.healthcareapp.models;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tg.healthcareapp.facades.DataSource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	private LocalDate appointmentDate;
	private DataSource _dataSource;
	@Autowired
	public Appointment(DataSource dataSource) {
		_dataSource=dataSource;
	}
	@Bean
	//spring object
	public Patient getPateint() {
		_dataSource.addData("Pateint Instance Created");
		//java object
		return new Patient();
	}

}
