package com.tg.appointmentapi.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tg.appointmentapi.dtos.ResponseWrapper;
import com.tg.appointmentapi.models.Appointment;
import com.tg.appointmentapi.services.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired 
	private AppointmentService appointmentService;
    
    @PostMapping("/v1.0/")
	@CrossOrigin(allowedHeaders = "*",origins = "*", 
	methods=RequestMethod.POST)
    public ResponseEntity<ResponseWrapper> addAppointment(@RequestBody 
    		Appointment Appointment){
    	
    	Appointment AppointmentResponse=this.appointmentService.addAppointment(Appointment);
    	return ResponseEntity.status(HttpStatus.OK).body(new 
    			ResponseWrapper(AppointmentResponse));
    	
    }
    
    @GetMapping("/v1.0/")
   	@CrossOrigin(allowedHeaders = "*",origins = "*", 
   	methods=RequestMethod.GET)
       public ResponseEntity<ResponseWrapper> getAllAppointments(){
       	
    	List<Appointment> appointmentResponse=this.appointmentService.getAllAppointments();
    	return ResponseEntity.status(HttpStatus.OK).body(new 
    			ResponseWrapper(appointmentResponse));
       	
       }
    
    
    @GetMapping("/v1.0/{appointmentId}")
   	@CrossOrigin(allowedHeaders = "*",origins = "*", 
   	methods=RequestMethod.GET)
       public ResponseEntity<ResponseWrapper> getAppointmentById(@PathVariable("appointmentId") String appointmentId){
       	
    	Appointment appointmentResponse=this.appointmentService.getAppointmentById(appointmentId);
    	return ResponseEntity.status(HttpStatus.OK).body(new 
    			ResponseWrapper(appointmentResponse));
       	
       }
    
    
    @PutMapping("/v1.0/{appointmentId}/{date}")
   	@CrossOrigin(allowedHeaders = "*",origins = "*", 
   	methods=RequestMethod.PUT)
       public ResponseEntity<ResponseWrapper> updateAppointment(@PathVariable("appointmentId") String appointmentId, 
    		   @PathVariable("date") String date ){
       	
    	LocalDate doa=LocalDate.parse(date);
       	Appointment appointmentResponse=this.appointmentService.updateAppointment(appointmentId,doa);
       	return ResponseEntity.status(HttpStatus.OK).body(new 
       			ResponseWrapper(appointmentResponse));
       	
       }
    
    @DeleteMapping("/v1.0/{appointmentId}")
   	@CrossOrigin(allowedHeaders = "*",origins = "*", 
   	methods=RequestMethod.DELETE)
       public ResponseEntity<ResponseWrapper> deleteAppointment(@PathVariable("appointmentId") String appointmentId){
       	
       	boolean status=this.appointmentService.deleteAppointment(appointmentId);
       	if(status)
       	  return ResponseEntity.status(HttpStatus.OK).body(new 
       			ResponseWrapper("Appointment With this Id"+appointmentId+"Deleted"));
       	else
       		return ResponseEntity.status(HttpStatus.OK).body(new 
           			ResponseWrapper("Appointment With this Id"+appointmentId+"not Deleted"));
       	
       }
}
