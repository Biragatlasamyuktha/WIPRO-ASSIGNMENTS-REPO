package com.example.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomFilterChain {
	public static void main(String[] args) {
        List<String> names = Arrays.asList("Anna", "Amanda", "Alex", "Brian", "Alina", "Sasha", "Bob");

        // Predicate: Starts with "A"
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Predicate: Ends with "a"
        Predicate<String> endsWithA = name -> name.endsWith("a");

        // Combine predicates (e.g., both start with A AND end with a)
        Predicate<String> combined = startsWithA.and(endsWithA);

        // Filter using combined predicate
        List<String> filteredNames = names.stream()
                .filter(combined)
                .collect(Collectors.toList());

        System.out.println("Filtered Names: " + filteredNames);
        // Output: Filtered Names: [Anna, Amanda, Alina]
    }

}
