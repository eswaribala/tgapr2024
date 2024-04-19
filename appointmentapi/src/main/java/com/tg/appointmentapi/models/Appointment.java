package com.tg.appointmentapi.models;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Appointment")
public class Appointment implements Serializable{
	@Id
	@GenericGenerator(name="appointment_id",strategy = "com.tg.appointmentapi.models.IdGenerator")
    @GeneratedValue(generator = "appointment_id")
	@Schema(hidden = true)  
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Appointment_Id")
	private String appointmentId;
	@Column(name="Appointment_Date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate doa;
	@Column(name="Appointment_Time")
	private String appointmentTime;
	@Column(name="Doctor_Id")
	private long doctorId;
	@Column(name="Patient_Id")
	private long patientId;
	

}
