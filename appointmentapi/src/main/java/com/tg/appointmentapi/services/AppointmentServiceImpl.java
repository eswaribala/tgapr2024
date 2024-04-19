package com.tg.appointmentapi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private RestTemplate restTemplate;
    private ResponseEntity<String> response;
    @Value("${patientApiUrl}")
    private String patientApiUrl;
	@Override
	public Appointment addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		long recdPatientId=0;
		boolean status=false;
		Appointment appointmentRequest=null;
		if(appointment.getAppointmentId()!=null) {
		
			appointmentRequest=this.appointmentRepo.findById(appointment.getAppointmentId())
				.orElse(null);
		}
		if(appointmentRequest!=null){
			log.info("Appointment Already Exists");
			throw new AppointmentAlreadyExistsException("Appointment details Already Found!!!");
		}else
		{
			
			  response=restTemplate.exchange(patientApiUrl+appointment.getPatientId(),
						HttpMethod.GET,null,String.class);
			  log.info("Response"+response.getBody());
				if(response.getBody()!=null) {
				JsonParser springParser = JsonParserFactory.getJsonParser();
			      Map < String, Object > map = springParser.parseMap(response.getBody());
			      String mapArray[] = new String[map.size()];
			      System.out.println("Patient found: " + mapArray.length);
			      int i = 0;
			      for (Map.Entry < String, Object > entry: map.entrySet()) {
			        System.out.println(entry.getKey() + " = " + entry.getValue());
			        		        
			        if(entry.getKey()=="object") {
			        	status=true;
			        	//recdPatientId=Long.parseLong(entry.getValue().toString());
			            break;
			        }
			        i++;
			      }
				}
			log.info("Received Patient Id"+recdPatientId);	
			
			if(status) {
				log.info("Appointment Created");
		        return this.appointmentRepo.save(appointment);
			}
			else
				throw new AppointmentNotFoundException("Patient Id not matching....");
		}
	}

	@Override
	
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return this.appointmentRepo.findAll();
	}

	@Override
	
	public Appointment getAppointmentById(String appointmentId) {
		// TODO Auto-generated method stub
		return this.appointmentRepo.findById(appointmentId)
				.orElseThrow(()->new 
						AppointmentNotFoundException("Appointment not "
								+ "found with given Id"));
	}

	@Override
	
	public Appointment updateAppointment(String appointmentId, LocalDate date) {
		
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
	
	public boolean deleteAppointment(String AppointmentId) {
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
