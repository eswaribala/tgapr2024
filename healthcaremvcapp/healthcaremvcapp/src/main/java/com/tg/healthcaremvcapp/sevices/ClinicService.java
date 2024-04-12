package com.tg.healthcaremvcapp.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.healthcaremvcapp.models.Clinic;
import com.tg.healthcaremvcapp.repositories.ClinicRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class ClinicService {
	@Autowired
	private ClinicRepository clinicRepository;
	@Autowired
	private EntityManager entityManager;
	
	//add clinic
	public Clinic addClinic(Clinic clinic) {
		return this.clinicRepository.save(clinic);
	}
	
	//select all clinic
	public List<Clinic> getAllClinic(){
		return this.clinicRepository.findAll();
	}
	
	//retrieve clinic by Id
	
	public Clinic getClinicById(String clinicId) {
		return this.clinicRepository.findById(clinicId).orElse(null);
	}
	
	//retrieve clinics by Name
	public List<Clinic> getClinicByName(String clinicName){
		
		CriteriaBuilder cb= entityManager.getCriteriaBuilder();
		CriteriaQuery<Clinic> cq= cb.createQuery(Clinic.class);
		Root<Clinic> root= cq.from(Clinic.class);
		cq.where(cb.equal(root.get("clinicName"), clinicName));
		CriteriaQuery<Clinic> result=cq.select(root);
		TypedQuery<Clinic> typedQuery= entityManager.createQuery(result);
		return typedQuery.getResultList();
	}
	

}
