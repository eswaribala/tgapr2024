package com.tg.healthcareapp.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {
	
	private String clinicId;
	private String clinicName;
	private String businessName;
	private Address address;
	private List<Service> services;

}
