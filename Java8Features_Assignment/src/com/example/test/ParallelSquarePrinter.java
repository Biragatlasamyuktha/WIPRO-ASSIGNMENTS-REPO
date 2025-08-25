package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParallelSquarePrinter {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        List<Integer> numbers = new ArrayList<>();

	        // Take input count
	        System.out.print("How many numbers do you want to enter? ");
	        int count = scanner.nextInt();

	        // Read numbers from user
	        for (int i = 0; i < count; i++) {
	            System.out.print("Enter number " + (i + 1) + ": ");
	            numbers.add(scanner.nextInt());
	        }

	        System.out.println("\nSquares (printed using parallelStream):");

	        // Use parallelStream to compute and print squares
	        numbers.parallelStream()
	               .forEach(num -> System.out.println("Square of " + num + " = " + (num * num)));

	        scanner.close();
	    }
	

}
