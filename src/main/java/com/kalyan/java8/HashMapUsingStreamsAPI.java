package com.kalyan.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HashMapUsingStreamsAPI {

	public static void main(String[] args) {

		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "Apple");
		hashMap.put(2, "Banana");
		hashMap.put(3, "Grapes");
		hashMap.put(4, "Mango");
		hashMap.put(5, "WaterMelon");
		hashMap.put(5, "WaterMelon");
		System.out.println("All Values in Map::");
		System.out.println(hashMap);

		// Extract specific key-value pairs based on a condition

		Map<Integer, String> filteredMap = hashMap.entrySet().stream().filter(e -> e.getKey() > 2)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		System.out.println("Filtered Map is ::" + filteredMap);

		// Fetching a Specific Key or Value
		Map<Integer, String> specificValueFromMap = hashMap.entrySet().stream().filter(e -> e.getKey() == 2)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

		System.out.println("Specific Entry from Map ::" + specificValueFromMap);

		// Tranforming the Entries
		Map<Integer, String> transformedKeyValues = hashMap.entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey() - 1, e -> e.getValue().toUpperCase()));
		System.out.println(transformedKeyValues);

		// Group by First Letter of Values: //Output: {A=[Apple], B=[Banana],
		// C=[Cherry], D=[Date]}
		// Collectors.mapping()--> it is used to get specific record, value from the Map
		Map<Character, List<String>> groupedByFirstLetter = hashMap.entrySet().stream()
				.collect(Collectors.groupingBy(e -> e.getValue().charAt(0), // Group by first character of the value
						Collectors.mapping(Map.Entry::getValue, Collectors.toList()) // Map to list of values
				));

		System.out.println(groupedByFirstLetter);

	}
}
