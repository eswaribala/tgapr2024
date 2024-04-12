package com.tg.healthcaremvcapp.sevices;

import java.util.List;

import com.tg.healthcaremvcapp.models.Clinic;

public interface ClinicService {
	 Clinic addClinic(Clinic clinic);
	 List<Clinic> getAllClinic();
	 Clinic getClinicById(String clinicId);
	 List<Clinic> getClinicByName(String clinicName);
	 Clinic updateClinic(String businessName,String clinicId);
	 boolean deleteClinic(String clinicId);
}
