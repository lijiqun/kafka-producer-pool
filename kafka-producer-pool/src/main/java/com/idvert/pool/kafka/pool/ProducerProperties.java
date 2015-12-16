package com.idvert.pool.kafka.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ProducerProperties{
	
	private static final Properties pro;
	private static final String FILE_NAME="producer.properties";
	
	static{
		InputStream input = ProducerProperties.class.getClassLoader().getResourceAsStream(FILE_NAME);
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
