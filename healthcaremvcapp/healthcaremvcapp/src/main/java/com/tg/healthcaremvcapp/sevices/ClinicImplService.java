package com.tg.healthcaremvcapp.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.healthcaremvcapp.models.Clinic;
import com.tg.healthcaremvcapp.models.ServicesOffered;
import com.tg.healthcaremvcapp.repositories.ClinicRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class ClinicImplService implements ClinicService{
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
	//retrieve clinic by name
	public List<Clinic> getClinicByName(String clinicName){
		
		//return this.clinicRepository.findByClinicName(clinicName);
		
		  CriteriaBuilder cb= entityManager.getCriteriaBuilder(); CriteriaQuery<Clinic>
		  cq= cb.createQuery(Clinic.class); Root<Clinic> root= cq.from(Clinic.class);
		  cq.where(cb.equal(root.get("clinicName"), clinicName)); CriteriaQuery<Clinic>
		  result=cq.select(root); TypedQuery<Clinic> typedQuery=
		  entityManager.createQuery(result); return typedQuery.getResultList();
		 
	}
	
	
	//retrieve clinics by Name and business name
	/*
	 * public List<Clinic> getClinicByName(String clinicName, String businessName){
	 * 
	 * CriteriaBuilder cb= entityManager.getCriteriaBuilder(); CriteriaQuery<Clinic>
	 * cq= cb.createQuery(Clinic.class); Root<Clinic> root= cq.from(Clinic.class);
	 * Predicate predicateForClinicName = cb.equal(root.get("clinicName"),
	 * clinicName); Predicate predicateForBusinessName
	 * =cb.equal(root.get("businessName"), businessName); Predicate finalPredicate=
	 * cb.and(predicateForClinicName, predicateForBusinessName);
	 * cq.where(finalPredicate); CriteriaQuery<Clinic> result=cq.select(root);
	 * TypedQuery<Clinic> typedQuery= entityManager.createQuery(result); return
	 * typedQuery.getResultList(); }
	 */
	
	public Clinic updateClinic(String businessName,String clinicId) {
		
		Clinic clinic=this.clinicRepository.findById(clinicId).orElse(null);
		if(clinic!=null) {
			clinic.setBusinessName(businessName);
			return this.clinicRepository.save(clinic);
		}else {
			return null;
		}
		
		
	}
	
	public boolean deleteClinic(String clinicId) {
			boolean status=false;
			Clinic clinic=this.clinicRepository.findById(clinicId).orElse(null);
			if(clinic!=null) {
				this.clinicRepository.delete(clinic);
				status=true;
			}
			return status;
			
			
		}
	

}
