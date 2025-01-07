package com.kalyan.java8;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, -1);
		System.out.println(numbers);

		Integer totalSum = numbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println("The total Sum in Element::" + totalSum);
		System.out.println("Find Max Element : ");
		Integer maxElement = numbers.stream().reduce(Integer::max).get();
		System.out.println(maxElement);

		List<String> words = Arrays.asList("Java", "is", "Awesome");
		String trimed = words.stream().reduce("", (a, b) -> a + " " + b).trim();
		System.out.println(trimed);
		List<String> listOfStrings = Arrays.asList("Hi", "Thalari", "Kalyan", "How", "are", "you", "doing");
		String longestWords = listOfStrings.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)
				.orElse("No Words");
		System.out.println(longestWords);
		
		List<Integer> listOfAllNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer sumOfEvenNumbers = listOfAllNumbers.stream().filter(e -> (e % 2 == 0)).map(e -> e * e)
				.reduce(Integer::sum).get();
		System.out.println(sumOfEvenNumbers);
		List<String> wordsValues = Arrays.asList("Java", "is", "Awesome", "Applications");
		String updatedStrings = wordsValues.stream().reduce((a, b) -> a + "::" + b).get();
		System.out.println(updatedStrings);
		System.out.println("Minimum Number is Given List");
		Integer minimumNumber = numbers.stream().reduce(Integer::min).get();
		System.out.println(minimumNumber);
	}

}
