package com.tg.appointmentapi.services;

import java.time.LocalDate;
import java.util.List;

import com.tg.appointmentapi.models.Appointment;

public interface AppointmentService {
	
	Appointment addAppointment(Appointment patient);
	List<Appointment> getAllAppointments();
	Appointment getAppointmentById(long patientId);
	Appointment updateAppointment(long appointmentId, LocalDate date);
	boolean deleteAppointment(long appointmentId);

}
