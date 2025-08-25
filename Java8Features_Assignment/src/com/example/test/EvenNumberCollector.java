package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EvenNumberCollector {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        // Take number of inputs
        System.out.print("How many numbers do you want to enter? ");
        int count = scanner.nextInt();

        // Take the numbers
        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }

        // Filter even numbers and collect them into a list
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0)
                                           .collect(Collectors.toList());

        // Print the result
        System.out.println("\nEven numbers:");
        evenNumbers.forEach(System.out::println);

        scanner.close();
    }

}
