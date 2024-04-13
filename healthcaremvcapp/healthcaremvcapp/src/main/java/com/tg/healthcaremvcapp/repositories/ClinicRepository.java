package com.tg.healthcaremvcapp.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.tg.healthcaremvcapp.models.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, String>{
	// @Query("Select c from Clinic c where c.clinicName=:clinicName")
	//    public List<Clinic> findByClinicName(@Param("clinicName") String clinicName);
}
