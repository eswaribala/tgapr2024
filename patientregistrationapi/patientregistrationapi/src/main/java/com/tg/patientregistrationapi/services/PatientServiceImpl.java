package com.tg.patientregistrationapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.patientregistrationapi.exceptions.PatientAlreadyExistsException;
import com.tg.patientregistrationapi.exceptions.PatientNotFoundException;
import com.tg.patientregistrationapi.models.Patient;
import com.tg.patientregistrationapi.repositories.PatientRepository;
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
	private PatientRepository patientRepo;
	
	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		if(this.getPatientById(patient.getPatientId())!=null){
			throw new PatientAlreadyExistsException("Patient details Already Found!!!");
		}else
			
		return this.patientRepo.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return this.patientRepo.findAll();
	}

	@Override
	public Patient getPatientById(long patientId) {
		// TODO Auto-generated method stub
		return this.patientRepo.findById(patientId)
				.orElseThrow(()->new 
						PatientNotFoundException("Patient not "
								+ "found with given Id"));
	}

	@Override
	public Patient updatePatient(long patientId, long mobileNo) {
		
		Patient patient=this.getPatientById(patientId);
		// TODO Auto-generated method stub
		if(patient!=null){
			 patient.setMobileNo(mobileNo);
			 return this.patientRepo.save(patient);
			
		}else
			throw new PatientNotFoundException("Patient not "
					+ "found with given Id");
		  
	}

	@Override
	public boolean deletePatient(long patientId) {
		boolean status=false;
		// TODO Auto-generated method stub
		Patient patient=this.getPatientById(patientId);
		// TODO Auto-generated method stub
		if(patient!=null){
			 
			this.patientRepo.deleteById(patientId);
			status=true;
			return status;
		}else
			throw new PatientNotFoundException("Patient not "
					+ "found with given Id");
		  
	}

}
