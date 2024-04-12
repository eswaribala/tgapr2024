package com.tg.healthcareapp.utilities;

import com.tg.healthcareapp.models.Address;
import com.tg.healthcareapp.models.Appointment;

//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
//import org.springframework.core.io.ClassPathResource;

import com.tg.healthcareapp.models.Clinic;
import com.tg.healthcareapp.models.DentalClinic;
import com.tg.healthcareapp.models.MysqlDataSource;
import com.tg.healthcareapp.models.OracleDataSource;
import com.tg.healthcareapp.models.Patient;
import com.tg.healthcareapp.models.Service;
import com.tg.healthcareapp.models.ServicesOffered;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClinicApp {

	private static final Logger logger=LoggerFactory.getLogger(ClinicApp.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Bean Factory
		//DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//reader.loadBeanDefinitions(new ClassPathResource("healthcare-spring-config.xml"));	
		
		//Annotation based using Application Context
		
		//ApplicationContext ctx= new 
			//	ClassPathXmlApplicationContext("healthcare-spring-config.xml");
		
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.register(Clinic.class);
		//ctx.register(Address.class);
		//ctx.register(Service.class);
		ctx.register(DentalClinic.class);
		ctx.register(Appointment.class);
		ctx.register(MysqlDataSource.class);
		ctx.register(OracleDataSource.class);
		//to avoid illegal state exception
		ctx.refresh();
		
		/*
		 * Address address1=(Address) ctx.getBean("address"); address1.setDoorNo("16");
		 * address1.setStreetName("First Street"); address1.setPostalCode(602024);
		 * address1.setState("TamilNadu"); address1.setCity("Chennai");
		 * address1.setCountry("India"); address1.setLongitude("18.5");
		 * address1.setLatitude("33.3");
		 */
		
		
		
		//List<Service> services=new ArrayList<Service>();
		
		/*
		 * Service consultingService=(Service) ctx.getBean("service");
		 * consultingService.setActive(true); consultingService.setServiceId(2854832);
		 * consultingService.setServiceDescription("Consultation");
		 * consultingService.setServiceName(ServicesOffered.Consultation);
		 * services.add(consultingService);
		 * 
		 * Service xRayService=(Service) ctx.getBean("service");
		 * xRayService.setActive(true); xRayService.setServiceId(2854833);
		 * xRayService.setServiceDescription("XRay");
		 * xRayService.setServiceName(ServicesOffered.Xray); services.add(xRayService);
		 */
		
		//IOC
		//injected the object
		
		  Clinic clinic1=(Clinic) ctx.getBean("clinic");
		  System.out.println("Clinic Id-->"+clinic1.getClinicId());
		  System.out.println("Clinic Name-->"+clinic1.getClinicName());	
		  Address address=clinic1.getAddress();		
			address.setDoorNo("16");
			address.setStreetName("First Street");
			address.setPostalCode(602024);
			address.setState("Karnataka");
			address.setCity("Bangalore");
			address.setCountry("India");
			address.setLongitude("18.5");
			address.setLatitude("33.3");
		//  clinic1.setAddress(address1);
			logger.info("Clinic City-->"+clinic1.getAddress().getCity());
			logger.info("Clinic Services");  
		  List<Service> services=clinic1.getServices();
          Service xRayService=services.get(0);
		  xRayService.setActive(true); xRayService.setServiceId(2854833);
	      xRayService.setServiceDescription("XRay");
		  xRayService.setServiceName(ServicesOffered.Xray); 
		  		  
		 // clinic1.setServices(services);
		  clinic1.getServices().stream().forEach(System.out::println);
			
		  Clinic clinic2=(Clinic) ctx.getBean("clinic");
		  clinic2.setClinicId("CL32845835284");
		  logger.info("Clinic Id-->"+clinic2.getClinicId());
		  logger.info("Clinic Name-->"+clinic2.getClinicName()); 
		  //after  updating clinic Id 
		  logger.info("Clinic Id-->"+clinic1.getClinicId());		  
		  
		  DentalClinic dentalClinic=(DentalClinic) ctx.getBean("dentalClinic");
		  logger.info("Clinic Id-->"+dentalClinic.isCbctScan());
			 
		 //access appointment
		 Appointment appointment=(Appointment) ctx.getBean("appointment");
		 appointment.setAppointmentDate(LocalDate.now().plusDays(7));
		 logger.info(appointment.getAppointmentDate().toString());
		 Patient patient=appointment.getPateint();
		 logger.info(String.valueOf(patient.getContactNo()));
		  
		 ctx.registerShutdownHook();
	}

}
