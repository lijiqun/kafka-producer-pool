package com.idvert.pool.kafka.keydpool;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.idvert.pool.kafka.producer.IKafkaProducer;
import com.idvert.pool.kafka.producer.KafkaProducer;

public class ProducerKeydFactory extends BaseKeyedPooledObjectFactory<String, IKafkaProducer> {
	
	private KafkaProducer p;
	private String topic;
	
	@Override
	public IKafkaProducer create(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PooledObject<IKafkaProducer> wrap(IKafkaProducer value) {
		return new DefaultPooledObject<IKafkaProducer>(value);
	}

}
