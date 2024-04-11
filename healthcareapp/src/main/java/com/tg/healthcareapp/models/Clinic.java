package com.tg.healthcareapp.models;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Component
@Import({Address.class, Service.class,ClinicConfig.class})
public class Clinic implements BeanNameAware, ApplicationContextAware,
InitializingBean, BeanFactoryAware,DisposableBean{
	private static final Logger logger=LoggerFactory.getLogger(Clinic.class);
	private String clinicId;
	private String clinicName;
	private String businessName;
	@Autowired	
	private Address address;
	@Autowired
	private List<Service> services;
	

	public Clinic() {
		super();
		logger.info("Enters Clinic No Args Constructor");
		// TODO Auto-generated constructor stub
	}

	public Clinic(String clinicId, String clinicName, String businessName, Address address, List<Service> services) {
		super();
		logger.info("Enters Clinic All Args Constructor");
		this.clinicId = clinicId;
		this.clinicName = clinicName;
		this.businessName = businessName;
		this.address = address;
		this.services = services;
	}
	
	
	
	
	
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		logger.info("Enters Bean Name="+name);
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("Enters Clinic Bean Factory"+beanFactory.getClass().getName());
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Enters After Properties Set");
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("Enters Application Context");
	}
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		logger.info("Enters destroy method");
		
	}


	@PostConstruct
	public void customIntit() {
		
		logger.info("Entering custom Initialization method....");
	}
	
	@PreDestroy
	public void customDelete() {
		logger.info("Before Destroying bean invokes custom destory method....");
	}



}
