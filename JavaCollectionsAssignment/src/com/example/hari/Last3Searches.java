package com.example.hari;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Last3Searches {
	public static void main(String[] args) {
        ArrayDeque<String> searchHistory = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter search terms (type 'exit' to stop):");

        while (true) {
            String term = scanner.nextLine();

            if (term.equalsIgnoreCase("exit")) {
                break;
            }

            // If full, remove the oldest (from front)
            if (searchHistory.size() == 3) {
                searchHistory.removeFirst();
            }

            // Add new term to the end
            searchHistory.addLast(term);

            // Display current search history
            System.out.println("Current search history: " + searchHistory);
        }

        System.out.println("Final search history: " + searchHistory);
    }

}
