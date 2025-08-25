package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleNameSorter {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.println("Enter 5 names:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names.add(scanner.nextLine());
        }

        // Sort using lambda expression (case-insensitive)
        names.sort((name1, name2) -> name1.compareToIgnoreCase(name2));

        System.out.println("\nSorted names:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }

}
