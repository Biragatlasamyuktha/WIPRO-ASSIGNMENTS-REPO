package com.example.hari;

import java.util.ArrayDeque;
import java.util.Scanner;

public class GroceryLineShuffle {
	public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 customer names:");

        for (int i = 0; i < 5; i++) {
            String name = scanner.nextLine();

            if (name.length() % 2 == 0) {
                queue.addFirst(name);  // Even length -> front
            } else {
                queue.addLast(name);   // Odd length -> end
            }
        }

        System.out.println("\nServing customers in order:");
        while (!queue.isEmpty()) {
            System.out.println("Serving: " + queue.pollFirst());
        }
    }

}
