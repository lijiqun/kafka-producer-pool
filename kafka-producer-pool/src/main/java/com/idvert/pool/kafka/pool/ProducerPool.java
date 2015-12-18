package com.idvert.pool.kafka.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerPool<IKafkaProducer> extends GenericObjectPool<IKafkaProducer>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerPool.class);

	public ProducerPool(PooledObjectFactory<IKafkaProducer> factory) {
		super(factory);
	}
	
	public ProducerPool(PooledObjectFactory<IKafkaProducer> factory,GenericObjectPoolConfig config) {
		super(factory,config);
	}
	
	@Override
	public IKafkaProducer borrowObject() throws Exception {
		IKafkaProducer producer = super.borrowObject();
		LOGGER.info("log borrow object "+producer.toString());
		return producer;
	}
	
	

}
