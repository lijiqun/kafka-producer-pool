package com.idvert.pool.kafka.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

@SuppressWarnings("hiding")
public class ProducerPool<IKafkaProducer> extends GenericObjectPool<IKafkaProducer>{

	public ProducerPool(PooledObjectFactory<IKafkaProducer> factory) {
		super(factory);
		this.setConfig(new PoolProperties());
	}

}
