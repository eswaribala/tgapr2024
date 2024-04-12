package com.tg.healthcaremvcapp.models;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Service_Id")
	private long serviceId;
    @Enumerated(EnumType.STRING)
    @Column(name="Service_Offered")
	private ServicesOffered serviceName;
    @Column(name="Service_Description",length = 150,nullable = false)
	private String serviceDescription;
    @Column(name="Service_Price")
	private long servicePrice;
    @Column(name="Is_Active")
	private boolean isActive;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   	@JoinColumn(foreignKey = @ForeignKey(name = "Clinic_Service_Id"),
               name = "Clinic_ServiceId_FK")
       private Clinic clinic;
}
