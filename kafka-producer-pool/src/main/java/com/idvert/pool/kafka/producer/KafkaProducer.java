package com.idvert.pool.kafka.producer;

import java.util.Properties;

import com.idvert.pool.kafka.util.ProducerProperties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer implements IKafkaProducer {
	
	private final Producer<String,byte[]> producer ;
	private final String topic;
	private final Properties props = ProducerProperties.getPro();
	
	
	
	public KafkaProducer(String topic) {
		this.producer = new Producer<String, byte[]>(new ProducerConfig(props));
		this.topic = topic;
	}

	@Override
	public void send(byte[] msg) throws Exception{
		producer.send(new KeyedMessage<String, byte[]>(topic, msg));
	}

	@Override
	public void close() {
	}

	@Override
	public void shutdown() {
	}
	
}
