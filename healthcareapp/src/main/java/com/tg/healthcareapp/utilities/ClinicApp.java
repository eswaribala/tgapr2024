package com.tg.healthcareapp.utilities;

//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
//import org.springframework.core.io.ClassPathResource;

import com.tg.healthcareapp.models.Clinic;
import com.tg.healthcareapp.models.DentalClinic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClinicApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Bean Factory
		//DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//reader.loadBeanDefinitions(new ClassPathResource("healthcare-spring-config.xml"));	
		
		//Annotation based using Application Context
		
		ApplicationContext ctx= new 
				ClassPathXmlApplicationContext("healthcare-spring-config.xml");
		
		
		//IOC
		//injected the object
		/*
		 * Clinic clinic1=(Clinic) factory.getBean("clinic");
		 * System.out.println("Clinic Id-->"+clinic1.getClinicId());
		 * System.out.println("Clinic Name-->"+clinic1.getClinicName());
		 * 
		 * Clinic clinic2=(Clinic) factory.getBean("clinic");
		 * clinic2.setClinicId("CL32845835284");
		 * System.out.println("Clinic Id-->"+clinic2.getClinicId());
		 * System.out.println("Clinic Name-->"+clinic2.getClinicName()); //after
		 * updating clinic Id System.out.println("Clinic Id-->"+clinic1.getClinicId());
		 * 
		 * 
		 * DentalClinic dentalClinic=(DentalClinic) factory.getBean("dentalClinic");
		 * System.out.println("Clinic Id-->"+dentalClinic.isCbctScan());
		 */
	}

}
