package com.example.test;

import java.util.Optional;
import java.util.Scanner;

public class SafeDivider {
	 public static Optional<Double> divide(double a, double b) {
	        if (b == 0) {
	            return Optional.empty(); // Return empty if divisor is 0
	        } else {
	            return Optional.of(a / b);
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Take input from user
	        System.out.print("Enter numerator: ");
	        double numerator = scanner.nextDouble();

	        System.out.print("Enter denominator: ");
	        double denominator = scanner.nextDouble();

	        // Call divide method
	        Optional<Double> result = divide(numerator, denominator);

	        // Print result or "Not Allowed"
	        if (result.isPresent()) {
	            System.out.println("Result: " + result.get());
	        } else {
	            System.out.println("Not Allowed");
	        }

	        scanner.close();
	    }
	

}
