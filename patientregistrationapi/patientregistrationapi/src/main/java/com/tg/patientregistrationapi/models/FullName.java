package com.tg.patientregistrationapi.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FullName {
	@Column(name="First_Name",length = 50,nullable = false )
	private String firstName;
	@Column(name="Middle_Name",length = 50)
	private String middleName;
	@Column(name="Last_Name",length = 50,nullable = false )
	private String lastName;

}
