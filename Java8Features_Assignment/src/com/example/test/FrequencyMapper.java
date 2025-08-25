package com.example.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyMapper {
	 public static Map<String, Long> getNameFrequencies(List<String> names) {
	        return names.stream()
	                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
	    }

	    public static void main(String[] args) {
	        List<String> nameList = Arrays.asList("Raju", "Ram", "Raju", "John", "Ram", "Raju");

	        Map<String, Long> frequencyMap = getNameFrequencies(nameList);

	        System.out.println(frequencyMap); 
	    }

}
