package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrettyJoiner {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> cities = new ArrayList<>();

        // Take number of city names
        System.out.print("How many city names do you want to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        // Take city names as input
        for (int i = 0; i < count; i++) {
            System.out.print("Enter city " + (i + 1) + ": ");
            cities.add(scanner.nextLine());
        }

        // Join city names into one comma-separated string
        String result = cities.stream()
                              .collect(Collectors.joining(", "));

        // Print the result
        System.out.println("\nJoined city names:");
        System.out.println(result);

        scanner.close();
    }

}
