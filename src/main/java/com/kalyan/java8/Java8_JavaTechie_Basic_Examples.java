package com.kalyan.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8_JavaTechie_Basic_Examples {

	public static void main(String[] args) {

		System.out.println("Count Occurence of each character in a String ::");

		String name = "ilovejavatechie";
		List<String> listOfStrings = Arrays.asList(name.split(""));
		Map<String, Long> countCharacters = listOfStrings.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countCharacters);

		// Function.identity()
		System.out.println("=================================================");

		System.out.println("Find Out all duplicate elements ::");
		List<String> duplicateCharacters = listOfStrings.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println(duplicateCharacters);

		System.out.println("=================================================");

		System.out.println("Find Out Unique elements ::");
		List<String> uniqueElements = listOfStrings.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println(uniqueElements);

		System.out.println("=================================================");

		System.out.println("Find Out First Unique element ::");
		Optional<String> findFirst = listOfStrings.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst();
		if (findFirst.isPresent())
			System.out.println(findFirst.get());

		System.out.println("=================================================");

		System.out.println("Find Out First repeated element ::");
		Optional<String> findFirstRepeated = listOfStrings.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).findFirst();
		if (findFirstRepeated.isPresent())
			System.out.println(findFirstRepeated.get());

		System.out.println("=================================================");

		System.out.println("Second Highest Number from Given Array ::  ");
		Integer[] numbers = { 5, 9, 11, 2, 8, 21, 1 };
		List<Integer> listOfNumbers = Arrays.asList(numbers);
		Integer secondHighestSalary = listOfNumbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.get();
		System.out.println(secondHighestSalary);

		System.out.println("=================================================");
		System.out.println("Find Longest String form given Array Of String ::");
		String[] strArray = { "java", "techie", "springboot", "microservices" };
		String longestString = Arrays.stream(strArray)
				.sorted(Comparator.comparing(e -> e.toString().length()).reversed()).findFirst().get();
		System.out.println(longestString);
		// we can use reduce() for comparing the strings
//		String longestString = Arrays.stream(strArray)
//				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
//		System.out.println(longestString);
		System.out.println("=================================================");
		System.out.println("Find the elements starts with 1 ::");
		int[] numbersValue = { 5, 9, 11, 2, 8, 21, 1 };
		List<String> elementsStartWithOne = Arrays.stream(numbersValue).mapToObj(Integer::toString)
				.filter(s -> s.startsWith("1")).collect(Collectors.toList());
		System.out.println(elementsStartWithOne);
		// mapToObj is used to convert each Integer element to String

//		List<String> elementsStartWithOne = Arrays.stream(numbersValue).boxed().map(e -> e + "")
//				.filter(s -> s.startsWith("1")).collect(Collectors.toList());---> int --->Integer --> String
		System.out.println("=================================================");

		System.out.println(":: Joins ::");
		String[] s = { "1", "2", "3", "4" };
		String joinedStrings = String.join(",", s);
		System.out.println(joinedStrings);
		
		

	}

}
