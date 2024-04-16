package com.tg.appointmentapi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tg.appointmentapi.exceptions.AppointmentAlreadyExistsException;
import com.tg.appointmentapi.exceptions.AppointmentNotFoundException;
import com.tg.appointmentapi.models.Appointment;
import com.tg.appointmentapi.repositories.AppointmentRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
	private AppointmentRepository appointmentRepo;
	
	@Override
	public Appointment addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		
		Appointment appointmentRequest=this.appointmentRepo.findById(appointment.getAppointmentId())
				.orElse(null);
		if(appointmentRequest!=null){
			log.info("Appointment Already Exists");
			throw new AppointmentAlreadyExistsException("Appointment details Already Found!!!");
		}else
		{
			log.info("Appointment Created");
		return this.appointmentRepo.save(appointment);
		}
	}

	@Override
	
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return this.appointmentRepo.findAll();
	}

	@Override
	
	public Appointment getAppointmentById(long appointmentId) {
		// TODO Auto-generated method stub
		return this.appointmentRepo.findById(appointmentId)
				.orElseThrow(()->new 
						AppointmentNotFoundException("Appointment not "
								+ "found with given Id"));
	}

	@Override
	
	public Appointment updateAppointment(long appointmentId, LocalDate date) {
		
		Appointment Appointment=this.getAppointmentById(appointmentId);
		// TODO Auto-generated method stub
		if(Appointment!=null){
			 Appointment.setDoa(date);
			 return this.appointmentRepo.save(Appointment);
			
		}else
			throw new AppointmentNotFoundException("Appointment not "
					+ "found with given Id");
		  
	}

	@Override
	
	public boolean deleteAppointment(long AppointmentId) {
		boolean status=false;
		// TODO Auto-generated method stub
		Appointment Appointment=this.getAppointmentById(AppointmentId);
		// TODO Auto-generated method stub
		if(Appointment!=null){
			 
			this.appointmentRepo.deleteById(AppointmentId);
			status=true;
			return status;
		}else
			throw new AppointmentNotFoundException("Appointment not "
					+ "found with given Id");
		  
	}

}
