package com.idvert.pool.kafka.pool;

public interface IKafkaProducer {
	
	void send(byte[] msg) throws Exception;

	void close();

	void shutdown();
}
