package com.example.hari;

import java.util.concurrent.LinkedBlockingQueue;

public class ChatProcessor {
	public static void main(String[] args) {
        LinkedBlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();

        // Producer thread: adds messages
        Thread producer = new Thread(() -> {
            int messageNumber = 1;
            try {
                while (true) {
                    // Pause if queue size > 5
                    while (messageQueue.size() > 5) {
                        Thread.sleep(100); // wait before checking again
                    }
                    String message = "Message-" + messageNumber++;
                    messageQueue.put(message); // blocks if queue full (unbounded here)
                    System.out.println("Produced: " + message);
                    Thread.sleep(200); // simulate delay between messages
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread: reads messages
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String msg = messageQueue.take(); // waits if empty
                    System.out.println("Consumed: " + msg);
                    Thread.sleep(500); // simulate message processing time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }

}
