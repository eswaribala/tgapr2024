package com.tg.healthcareapp.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
//@Scope("prototype")
public class Service {

	private long serviceId;
	private ServicesOffered serviceName;
	private String serviceDescription;
	private long servicePrice;
	private boolean isActive;
	
}
