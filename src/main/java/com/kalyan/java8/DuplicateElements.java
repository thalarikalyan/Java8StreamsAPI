package com.kalyan.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DuplicateElements {

	public static void main(String[] args) {

		int[] numbers = { 4, 2, 6, 7, 1, 9, 3, 1, 2 };

		// approch 1

		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			hashMap.put(numbers[i], hashMap.getOrDefault(numbers[i], 0) + 1);
		}
		System.out.println(hashMap);
		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue() != 1) {
				System.out.print(entry.getKey() + " ");
			}

		}

		// approch 2
		List<Integer> duplicateElementsInArray = Arrays.stream(numbers).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() != 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println(duplicateElementsInArray);

		
	}

}
