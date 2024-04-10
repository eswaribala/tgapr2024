package com.tg.healthcareapp.utilities;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.tg.healthcareapp.models.Clinic;


public class ClinicApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Bean Factory
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new ClassPathResource("healthcare-spring-config.xml"));	
		//IOC
		//injected the object
		Clinic clinic=(Clinic) factory.getBean("clinic");
		System.out.println("Clinic Id-->"+clinic.getClinicId());
		System.out.println("Clinic Name-->"+clinic.getClinicName());
	}

}
