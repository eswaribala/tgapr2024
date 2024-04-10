package com.tg.healthcareapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {

	private long serviceId;
	private ServicesOffered serviceName;
	private String serviceDescription;
	private long servicePrice;
	private boolean isActive;
	
}
