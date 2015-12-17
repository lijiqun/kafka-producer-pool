package com.idvert.pool.kafka.producer;

public interface IKafkaProducer {
	
	void send(byte[] msg) throws Exception;

	void close();

	void shutdown();
}
