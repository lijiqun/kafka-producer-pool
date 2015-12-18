package com.idvert.pool.kafka.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ProducerProperties{
	
	private static final Properties pro;
	private static final String FILE_NAME = "producer.properties";
	private static final String DEAULT_FILE_NAME = "producer_default.properties";
	
	static{
		InputStream input = ProducerProperties.class.getClassLoader().getResourceAsStream(FILE_NAME);
		if(input == null){
			input = ProducerProperties.class.getClassLoader().getResourceAsStream(DEAULT_FILE_NAME);
		}
		pro = new Properties();
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getPro() {
		return pro;
	}
	
}
