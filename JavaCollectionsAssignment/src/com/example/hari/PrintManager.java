package com.example.hari;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class PrintManager {
	public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> printQueue = new ArrayBlockingQueue<>(3);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add print jobs (type 'start' to begin printing):");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("start")) {
                break;
            }

            // Try to add job if queue not full
            boolean added = printQueue.offer(input);
            if (!added) {
                System.out.println("Queue full! Skipping job: " + input);
            } else {
                System.out.println("Job added: " + input);
            }
        }

        System.out.println("\nPrinting jobs one by one:");

        while (!printQueue.isEmpty()) {
            String job = printQueue.poll();
            System.out.println("Printing: " + job);
            Thread.sleep(1000); // simulate printing delay
        }

        System.out.println("All print jobs completed.");
    }

}
