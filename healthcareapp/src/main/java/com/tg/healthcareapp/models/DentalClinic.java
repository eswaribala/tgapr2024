package com.tg.healthcareapp.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Component
public class DentalClinic extends Clinic{

	private boolean cbctScan;
	
	
	
	
}
