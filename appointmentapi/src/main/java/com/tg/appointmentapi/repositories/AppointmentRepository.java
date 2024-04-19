package com.tg.appointmentapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tg.appointmentapi.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,String> {

}
