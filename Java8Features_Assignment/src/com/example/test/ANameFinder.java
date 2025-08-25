package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ANameFinder {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        // Take input from user
        System.out.print("How many names do you want to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < count; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names.add(scanner.nextLine());
        }

        // Filter names starting with "A" (case-insensitive)
        List<String> filteredNames = names.stream()
                .filter(name -> name.toLowerCase().startsWith("a"))
                .collect(Collectors.toList());

        // Print the filtered names
        System.out.println("\nNames starting with 'A':");
        filteredNames.forEach(System.out::println);

        scanner.close();
    }

}
