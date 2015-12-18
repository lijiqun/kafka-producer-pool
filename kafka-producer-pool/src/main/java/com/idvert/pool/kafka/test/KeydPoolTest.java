package com.idvert.pool.kafka.test;

import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

import com.idvert.pool.kafka.keydpool.ProducerKeyPool;
import com.idvert.pool.kafka.keydpool.ProducerKeydFactory;
import com.idvert.pool.kafka.producer.IKafkaProducer;

public class KeydPoolTest {
	
	public static void main(String[] args) {
		ProducerKeyPool pool = new ProducerKeyPool(new ProducerKeydFactory());
//		pool.addObject("test");
//		pool.addObject("test1");
//		pool.addObject("test2");
		
		GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
		config.setMaxWaitMillis(5000);
		pool.setConfig(config);
		
		for(int i=0 ; i<10 ;i++){
			IKafkaProducer producer;
			try {
				producer = pool.borrowObject("test");
				System.out.println(pool.getMaxTotalPerKey());
				System.out.println(pool.getNumActive("test"));
				producer.send("test".getBytes());
//				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
			
		}
		
		
		IKafkaProducer producer2;
		try {
			producer2 = pool.borrowObject("topic1");
			producer2.send("topic1".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
