package com.tg.healthcareapp.models;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ClinicBeanPostProcessor implements BeanPostProcessor {

	private static final Logger logger=LoggerFactory.getLogger(ClinicBeanPostProcessor.class);
	
	
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("Enter Bean PostProcessor Before Initialization");
		if(bean.getClass().getName().contains(beanName))
			logger.info("Enter Bean PostProcessor Before Initialization"+beanName);
		else
			logger.info("Enter Bean PostProcessor Before Initialization no beanName");
		
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		logger.info("After Bean PostProcessor After Initialization");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	
	
	
}
