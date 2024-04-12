package com.tg.healthcaremvcapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Clinic")
public class Clinic{
    @Id
    @Column(name="Clinic_Id",length = 15)
	private String clinicId;
    @Column(name="Clinic_Name",length = 75,nullable = false)
	private String clinicName;
    @Column(name="Business_Name",length = 75,nullable = false)
	private String businessName;

}
