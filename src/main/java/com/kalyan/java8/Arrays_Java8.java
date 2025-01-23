package com.kalyan.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arrays_Java8 {

	public static void main(String[] args) {
		int[] numbers = { 4, 2, 6, 7, 1, 9, 3, 1 };

		System.out.println("Find the maximum and minimum values in an integer array.");
		int[] array = Arrays.stream(numbers).sorted().toArray();
		System.out.println("Minimum Element is :: " + array[0]);
		System.out.println("Maximum Element is :: " + array[array.length - 1]);

		System.out.println("========================================================");

		String[] fruits = { "apple", "banana", "apple", "orange", "banana", "apple" };

		System.out.println("Count occurrences of each element in an array.");
		Map<String, Integer> collect = Arrays.stream(fruits).collect(Collectors.toList()).stream()
				.collect(Collectors.toMap(Function.identity(), // Key
						// Mapper
						item -> 1, // Value Mapper
						(existing, replacement) -> existing + replacement));
		System.out.println(collect);

		System.out.println("========================================================");

		System.out.println("3. Sort an array in ascending and descending order.");
		List<Integer> sortedLinkedList = Arrays.stream(numbers).boxed()
				.sorted(Comparator.comparing(Function.identity())).collect(Collectors.toList());
		System.out.println(sortedLinkedList);

		System.out.println("========================================================");

		System.out.println("4. Sort an array in ascending and descending order.");
		List<Integer> reversedSortedLinkedList = Arrays.stream(numbers).boxed() // Convert int[] to Stream<Integer>
				.sorted(Comparator.reverseOrder()) // Sort in reverse order
				.collect(Collectors.toList());
		System.out.println(reversedSortedLinkedList);

		System.out.println("========================================================");
		System.out.println("5. Remove duplicates from an array.");
		Set<Integer> uniqueElementsInArray = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
		System.out.println(uniqueElementsInArray);

		System.out.println("========================================================");

		System.out.println("6. Find the sum and average of an array.");

		double[] numbersDouble = { 10.5, 20.5, 30.0, 40.5, 50.0 };
		OptionalDouble average = Arrays.stream(numbersDouble).boxed().mapToDouble(e -> e.doubleValue()).average();
		if (average.isPresent()) {
			System.out.println("Average of Given Double value:: " + average.getAsDouble());
		} else {
			System.out.println("No average available.");
		}
		System.out.println("========================================================");

		System.out.println("7. Find the second highest number in an array.");
		Integer secondHigheshElemetnInArray = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1)
				.findFirst().get();
		System.out.println(secondHigheshElemetnInArray);
		System.out.println("========================================================");
		System.out.println("8. Convert the array into a List using Stream API");
		String[] colors = { "red", "blue", "green", "yellow" };
		List<String> convertArrayToList = Arrays.stream(colors).collect(Collectors.toList());
		System.out.println(convertArrayToList);
		System.out.println("========================================================");
		System.out.println("9. Find the longest string in an array.");
		String[] words = { "apple", "banana", "cherry", "watermelon", "grape" };
		String longestWord = Arrays.stream(words).toList().stream()
				.sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get();
		System.out.println(longestWord);

		System.out.println("========================================================");

		System.out.println("10. Group the strings based on their lengths using Stream API.");

		String[] stringsNames = { "cat", "dog", "elephant", "tiger", "abcde", "lion", "rat" };
		Arrays.stream(stringsNames).toList().stream().collect(Collectors.groupingBy(String::length)).entrySet().stream()
				.map(e -> e.getValue()).forEach(System.out::println);

		System.out.println("=============================================================");

		System.out.println("11. Convert 2-D to 1-D");
		String[][] twoDArray = { { "Kalyan", "Ravi" }, { "Mahesh", "Ganesh" }, { "preethi", "Suniths" } };
		List<String> singleArray = Arrays.stream(twoDArray).flatMap(Arrays::stream).collect(Collectors.toList());
		System.out.println(singleArray);

		System.out.println("========================================================");

		System.out.println("12. Find the first number greater than 5 using Stream API.");

		System.out.println("========================================================");
		int firstNumberGreaterThanFive = Arrays.stream(numbers).filter(n -> n > 5).findFirst().getAsInt();
		System.out.println(firstNumberGreaterThanFive);
		System.out.println("========================================================");

		int[] array1 = { 1, 2, 3 };
		int[] array2 = { 4, 5, 6 };
		System.out.println(" 13. Merge the two arrays into a single list using Stream API.");
		List<Integer> mergedTwoArrays = Stream.concat(Arrays.stream(array1).boxed(), Arrays.stream(array2).boxed())
				.collect(Collectors.toList());
		System.out.println(mergedTwoArrays);
		System.out.println("========================================================");
		System.out.println("14. Check if an array contains a specific element.");

		String[] names = { "John", "Alice", "Bob", "Charlie" };
		OptionalInt findFirst = IntStream.range(0, names.length).filter(i -> "Alice".contains(names[i])).findFirst();
		if (findFirst.isPresent()) {
			System.out.println("The Element is Found at Index ::" + findFirst.getAsInt());
		} else {
			System.out.println("-1");
		}
		System.out.println("========================================================");
		System.out.println("15. Create a comma-separated string from an array.");
		String[] cities = { "New York", "London", "Paris", "Tokyo" };
		String collectedJoinedString = Arrays.stream(cities).collect(Collectors.joining(","));
		System.out.println(collectedJoinedString);
		System.out.println("========================================================");
		System.out.println("Merge Two Sorted Arrays ::");
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		Set<Integer> sortedArrays = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed()).sorted()
				.collect(Collectors.toSet());
		System.out.println(sortedArrays);

		System.out.println("Rotate an array using Stream API.");

		

	}

}
