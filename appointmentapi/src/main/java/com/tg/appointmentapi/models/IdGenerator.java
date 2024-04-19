package com.tg.appointmentapi.models;

import java.time.LocalDate;
import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		// TODO Auto-generated method stub
		return "AP_" + new Random().nextInt(1000000) + "_" + LocalDate.now().getYear();

	}

}
