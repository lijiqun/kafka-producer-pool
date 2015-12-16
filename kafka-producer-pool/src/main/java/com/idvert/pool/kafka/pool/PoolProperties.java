package com.idvert.pool.kafka.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class PoolProperties extends GenericObjectPoolConfig{
	
	private final static Properties pro;
	private final static String FILE_NAME = "pool.properties";
	
	static{
		InputStream input = ProducerProperties.class.getClassLoader().getResourceAsStream(FILE_NAME);
		pro = new Properties();
		try {
			pro.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PoolProperties(){
		if(pro != null){
			this.setMaxTotal(Integer.parseInt((String)pro.get("maxTotal")));
			this.setMaxIdle(Integer.parseInt((String)pro.get("maxIdle")));
			this.setMaxWaitMillis(Long.parseLong((String)pro.get("maxWaitMillis")));
		}
	}
	
}
