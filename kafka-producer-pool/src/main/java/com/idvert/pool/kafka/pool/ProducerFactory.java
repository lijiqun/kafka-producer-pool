package com.idvert.pool.kafka.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ProducerFactory extends BasePooledObjectFactory<IKafkaProducer> {

	private KafkaProducer p;
	private String topic;

	public ProducerFactory(String topic) {
		this.topic = topic;
	}

	@Override
	public IKafkaProducer create() throws Exception {
		p = new KafkaProducer(topic);
		return p;
	}

	@Override
	public PooledObject<IKafkaProducer> wrap(IKafkaProducer arg0) {
		return new DefaultPooledObject<IKafkaProducer>(arg0);
	}
	
	@Override
	public void destroyObject(PooledObject<IKafkaProducer> p) throws Exception {
		this.p.close();
	}

}
