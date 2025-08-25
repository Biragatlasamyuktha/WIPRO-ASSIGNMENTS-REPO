package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCounter {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        List<String> names = new ArrayList<>();

	        // Take number of names
	        System.out.print("How many names do you want to enter? ");
	        int count = scanner.nextInt();
	        scanner.nextLine(); // consume leftover newline

	        // Take name inputs
	        for (int i = 0; i < count; i++) {
	            System.out.print("Enter name " + (i + 1) + ": ");
	            names.add(scanner.nextLine());
	        }

	        // Use stream to count names longer than 5 characters
	        long longNameCount = names.stream()
	                                  .filter(name -> name.length() > 5)
	                                  .count();

	        // Print the result
	        System.out.println("\nNumber of names longer than 5 characters: " + longNameCount);

	        scanner.close();
	    }
	

}
