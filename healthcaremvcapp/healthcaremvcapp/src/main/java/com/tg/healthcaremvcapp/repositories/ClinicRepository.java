package com.tg.healthcaremvcapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tg.healthcaremvcapp.models.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, String>{

}
