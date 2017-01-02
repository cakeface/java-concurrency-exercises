package com.ckfce.concurrent.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Standard Producer Consumer using a thread pool.  Example uses one producer thread and 
 * 2 consumers.
 * 
 * Code from https://dzone.com/articles/concurrency-pattern-producer
 */
public class ProducerConsumer {

    public static void main(String args[]) {
        try {
            Broker broker = new Broker();

            ExecutorService threadPool = Executors.newFixedThreadPool(3);

            threadPool.execute(new Consumer("1", broker));
            threadPool.execute(new Consumer("2", broker));
            Future<?> producerStatus = threadPool.submit(new Producer(broker));

            // this will wait for the producer to finish its execution.
            producerStatus.get();

            threadPool.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Broker {

        public ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        public Boolean continueProducing = Boolean.TRUE;

        public void put(Integer data) throws InterruptedException {
            this.queue.put(data);
        }

        public Integer get() throws InterruptedException {
            return this.queue.poll(1, TimeUnit.SECONDS);
        }
    }

    public static class Consumer implements Runnable {

        private String name;
        private Broker broker;

        public Consumer(String name, Broker broker) {
            this.name = name;
            this.broker = broker;
        }

        @Override
        public void run() {
            try {
                Integer data = broker.get();

                while (broker.continueProducing || data != null) {

                    System.out.println("Consumer " + this.name + " processed data from broker: " + data);

                    data = broker.get();
                }

                System.out.println("Comsumer " + this.name + " finished its job; terminating.");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static class Producer implements Runnable {

        private Broker broker;

        public Producer(Broker broker) {
            this.broker = broker;
        }

        @Override
        public void run() {
            try {
                for (Integer i = 1; i <= 100000; ++i) {
                    System.out.println("Producer produced: " + i);
                    broker.put(i);
                }

                this.broker.continueProducing = Boolean.FALSE;
                System.out.println("Producer finished its job; terminating.");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

}
