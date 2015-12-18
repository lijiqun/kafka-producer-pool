package com.idvert.pool.kafka.keydpool;

import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

import com.idvert.pool.kafka.producer.IKafkaProducer;

public class ProducerKeyPool extends GenericKeyedObjectPool<String,IKafkaProducer> {

	public ProducerKeyPool(KeyedPooledObjectFactory<String, IKafkaProducer> factory) {
		super(factory);
	}
	
	public ProducerKeyPool(KeyedPooledObjectFactory<String, IKafkaProducer> factory,GenericKeyedObjectPoolConfig config){
		super(factory,config);
	}

}
