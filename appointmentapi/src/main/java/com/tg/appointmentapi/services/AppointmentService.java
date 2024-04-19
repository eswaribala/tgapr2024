package com.tg.appointmentapi.services;

import java.time.LocalDate;
import java.util.List;

import com.tg.appointmentapi.models.Appointment;

public interface AppointmentService {
	
	Appointment addAppointment(Appointment appointment);
	List<Appointment> getAllAppointments();
	Appointment getAppointmentById(String appointmentId);
	Appointment updateAppointment(String appointmentId, LocalDate date);
	boolean deleteAppointment(String appointmentId);

}
