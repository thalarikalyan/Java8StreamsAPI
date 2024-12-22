package com.kalyan.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {

		// convert List of List Values to List

		List<List<Integer>> listOfListIntegers = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));

		List<List<Employee>> listOfListOfEmployees = Arrays.asList(

				Arrays.asList(new Employee(12345, "Kalyan", "Java Developer", 75000, "Hyderabad")),
				Arrays.asList(new Employee(12347, "Vedhansh", ".Net Developer", 65000, "Hyderabad")),
				Arrays.asList(new Employee(12346, "Venkatesh", ".Net Developer", 85000, "Warangal")),
				Arrays.asList(new Employee(12348, "Amadaiah", "Java Developer", 95000, "Hyderabad")),
				Arrays.asList(new Employee(12349, "Madhu", "Java Developer", 17000, "Warangal"))

		);
//		System.out.println(listOfListIntegers);
//		System.out.println("After ArrayList Usage ::: ");
//		List<Integer> listOfFlatteredRecords = listOfListIntegers.stream().flatMap(List::stream)
//				.collect(Collectors.toList());
//		System.out.println(listOfFlatteredRecords);
		System.out.println("Before ArrayList Usage ::");
		System.out.println(listOfListOfEmployees);
		System.out.println("Flatterd the List of List Of Arrays to Single List");
		Set<Employee> flatteredSetValues = listOfListOfEmployees.stream().flatMap(List::stream)
				.collect(Collectors.toSet());
		System.out.println(flatteredSetValues);

		List<String> sentences = Arrays.asList("Hello World", "Java 8 flatMap", "Stream API");

		// Using flatMap to split sentences into words
		List<String> words = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
				.collect(Collectors.toList());

		System.out.println(words); // Output: [Hello, World, Java, 8, flatMap, Stream, API]
		
		//flatMap is used in fetching the data from the which is having 1-Many relationships (Like Nested Mapping)  

	}

}
