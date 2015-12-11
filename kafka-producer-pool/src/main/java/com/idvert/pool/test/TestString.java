package com.idvert.pool.test;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class TestString {
	
	public static void main(String[] args) throws IllegalStateException, UnsupportedOperationException, Exception {
		GenericObjectPool<String> pool = new GenericObjectPool<String>(new StringFactory());
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(15);
		config.setMaxIdle(10);
		config.setMaxWaitMillis(5000);
		pool.setConfig(config);
		for (int i = 0; i < 10; i++) {
			pool.addObject();
			Thread.sleep(1000);
		}
		
		for(int i=0;i<16;i++){
			System.out.println("active : "+pool.getNumActive());
			System.out.println("idle : "+pool.getNumIdle());
			String borrow = pool.borrowObject();
			System.out.println(borrow);
			System.out.println("active : "+pool.getNumActive());
			System.out.println("idle : "+pool.getNumIdle());
			
		}
		
//		System.out.println("active : "+pool.getNumActive());
//		System.out.println("idle : "+pool.getNumIdle());
//		String borrow = pool.borrowObject();
//		System.out.println("active : "+pool.getNumActive());
//		System.out.println("idle : "+pool.getNumIdle());
//		pool.returnObject(borrow);
//		System.out.println("active : "+pool.getNumActive());
//		System.out.println("idle : "+pool.getNumIdle());
		pool.clear();
		pool.close();
	}
	
}
