package com.example.hari;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Job {
    String name;
    int urgency;

    public Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return "Job{name='" + name + "', urgency=" + urgency + "}";
    }
}

public class SmartJobPicker {
	 public static void main(String[] args) {
	        // PriorityQueue with custom comparator:
	        // Lower urgency → higher priority
	        // If equal, shorter name → higher priority
	        PriorityQueue<Job> jobQueue = new PriorityQueue<>(
	            Comparator.comparingInt((Job j) -> j.urgency)
	                      .thenComparingInt(j -> j.name.length())
	        );

	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter 5 jobs (name and urgency 1–5):");

	        for (int i = 0; i < 5; i++) {
	            System.out.print("Job name: ");
	            String name = scanner.nextLine();
	            System.out.print("Urgency (1–5): ");
	            int urgency = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            jobQueue.add(new Job(name, urgency));
	        }

	        System.out.println("\nJobs served in priority order:");
	        while (!jobQueue.isEmpty()) {
	            System.out.println(jobQueue.poll());
	        }
	    }
	

}
