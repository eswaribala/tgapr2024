package com.tg.healthcareapp.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tg.healthcareapp.facades.DataSource;
@Component
public class OracleDataSource implements DataSource{
	private static final Logger logger= LoggerFactory.
			getLogger(MysqlDataSource.class);
	@Override
	public void addData(String message) {
		// TODO Auto-generated method stub
		logger.info("Oracle"+message);
	}

}
