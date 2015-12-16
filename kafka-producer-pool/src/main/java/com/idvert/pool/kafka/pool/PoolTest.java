package com.idvert.pool.kafka.pool;

public class PoolTest {
	
	public static void main(String[] args)  {
//		GenericObjectPool<IKafkaProducer> pool = new GenericObjectPool<IKafkaProducer>(new ProducerFactory("test"));
//		pool.setConfig(new PoolProperties());
//		ExecutorService threadPool = Executors.newFixedThreadPool(20);
//		System.out.println(pool.getMaxIdle()+"idle");
//		System.out.println(pool.getMaxTotal()+"total");
		ProducerPool<IKafkaProducer> pool = new ProducerPool<IKafkaProducer>(new ProducerFactory("test"));
		
		for(int i=0;i<10;i++){
			try {
				pool.addObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for(int i=0;i<5;i++){
			IKafkaProducer producer = null;
			System.out.println("active : "+pool.getNumActive());
			System.out.println("idle : "+pool.getNumIdle());
			try {
				producer = pool.borrowObject();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				pool.returnObject(producer);
			}
			
			/*IKafkaProducer producer = null;
			try {
				producer = pool.borrowObject();
				threadPool.submit(new SendMessage(producer, i));
				System.out.println(pool.getMaxIdle()+"idle");
				System.out.println(pool.getMaxTotal()+"total");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				pool.returnObject(producer);
			}*/
			/*IKafkaProducer producer = null;
			try {
				producer = pool.borrowObject();
				producer.send("xxxxx".getBytes());
				System.out.println(pool.getMaxIdle()+"idle");
				System.out.println(pool.getMaxTotal()+"total");
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
//				pool.returnObject(producer);
			}*/
		}
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<5;i++){
			IKafkaProducer producer = null;
			System.out.println("active2 : "+pool.getNumActive());
			System.out.println("idle : "+pool.getNumIdle());
			try {
				producer = pool.borrowObject();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				pool.returnObject(producer);
			}
		}
		
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("final active : "+pool.getNumActive());
		System.out.println("final idle : "+pool.getNumIdle());
//		threadPool.shutdown();
	}
	
	static class SendMessage implements Runnable{
		
		private IKafkaProducer producer ;
		private int runNum;
		
		public SendMessage(IKafkaProducer producer,int runNum){
			this.producer = producer;
			this.runNum = runNum;
		}
		
		@Override
		public void run() {
			try {
//				System.out.println("sendMessage"+runNum);
				producer.send(new String("sendMessage"+runNum).getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
