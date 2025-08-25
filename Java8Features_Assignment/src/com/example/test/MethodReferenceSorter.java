package com.example.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodReferenceSorter {
	 public static void main(String[] args) {
	        List<String> words = Arrays.asList("Banana", "apple", "Orange", "grape");

	        // Sort using method reference
	        Collections.sort(words, String::compareToIgnoreCase);

	        // Output sorted list
	        for (String word : words) {
	            System.out.println(word);
	        }
	    }
	

}
