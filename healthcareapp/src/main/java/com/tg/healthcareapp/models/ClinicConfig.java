package com.tg.healthcareapp.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ClinicConfig {
	
	@Bean
	public ClinicBeanPostProcessor getBeanPostProcessor() {
		return new ClinicBeanPostProcessor();
	}

}
