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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.RequestContext;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;
import com.tg.appointmentapi.dtos.JwtRequest;
import com.tg.appointmentapi.dtos.JwtResponse;
import com.tg.appointmentapi.exceptions.AppointmentAlreadyExistsException;
import com.tg.appointmentapi.exceptions.AppointmentNotFoundException;
import com.tg.appointmentapi.models.Appointment;
import com.tg.appointmentapi.repositories.AppointmentRepository;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
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
    
    @Value("${signInUrl}")
    private String signInUrl;
    @Value("${jwtUserName}")
    private String userName;
    @Value("${jwtPassword}")
    private String password;
	@Override
	public Appointment addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		long recdPatientId=0;
		boolean status=false;
	    String token=null;
		JwtRequest jwtRequest=new JwtRequest();
		jwtRequest.setUserName(userName);	
		jwtRequest.setUserPwd(password);
		log.info(jwtRequest.getUserName());
		log.info(jwtRequest.getUserPwd());
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
			//retrieve jwt token
			
			//step1
			
			//call the patient api, get the token
			
			try {

				HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_JSON);
	            HttpEntity request = new HttpEntity<>(jwtRequest, headers);
	           
	            ResponseEntity<?> authResponse = restTemplate.
	                    postForEntity(signInUrl, request, String.class);
	            log.info(authResponse.getBody().toString());
	            token=parseString(authResponse.getBody().toString());

                  
	             //step 2
	            
	            headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_JSON);
	            headers.set("Authorization", "Bearer "+token);

	            request = new HttpEntity<String>(null,headers);

	            log.info("Patient Id"+appointment.getPatientId());
				  response=restTemplate.exchange(patientApiUrl+appointment.getPatientId(),
							HttpMethod.GET,request,String.class);
				  log.info("Response"+response);
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
				
			}catch(Exception e) {
				log.info(e.getMessage());
				throw new AppointmentNotFoundException("Patient Id not matching....");
			}
			
			
			
			//return null;
			
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
	
	
	/**
     * Response Exception Information to Front End
     */
   


    //response string to object and separates the token

    private String parseString(String response)
    {
        JSONParser parser = new JSONParser();
        String token="";
        try {

            // Put above JSON content to crunchify.txt file and change path location
            Object obj = parser.parse(response);
            JSONObject jsonObject = (JSONObject) obj;

            // JsonFlattener: A Java utility used to FLATTEN nested JSON objects
            String flattenedJson = JsonFlattener.flatten(jsonObject.toString());
            //log("\n=====Simple Flatten===== \n" + flattenedJson);

            Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());
            token=(String) flattenedJsonMap.get("token");
            //log("\n=====Flatten As Map=====\n" + flattenedJson);
            // We are using Java8 forEach loop. More info: https://crunchify.com/?p=8047
            //flattenedJsonMap.forEach((k, v) -> log(k + " : " + v));

            // Unflatten it back to original JSON
            String nestedJson = JsonUnflattener.unflatten(flattenedJson);
            System.out.println("\n=====Unflatten it back to original JSON===== \n" + nestedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;

    }


}
