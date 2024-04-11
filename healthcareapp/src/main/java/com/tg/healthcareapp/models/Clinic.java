package com.tg.healthcareapp.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Import({Address.class, Service.class})
public class Clinic {
	
	private String clinicId;
	private String clinicName;
	private String businessName;
	@Autowired	
	private Address address;
	@Autowired
	private List<Service> services;

}
