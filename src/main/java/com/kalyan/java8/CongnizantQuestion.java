package com.kalyan.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CognizantQuestion {

	// We have one map with string key, integer value need to sort the values based
	// on value

	public static void main(String[] args) {

		Map<String, Integer> hashmap = new HashMap<>();
		hashmap.put("Kalyan", 1385);
		hashmap.put("Ravi", 285);
		hashmap.put("Murali", 1987);
		hashmap.put("Ganesh", 1231);
		hashmap.put("Madhavi", 800);
		hashmap.put("Suresh", 126);
		hashmap.put("Preethi", 75);
		hashmap.put("sirisha", 25000);
		System.out.println(hashmap);
		System.out.println("Sort the map based onn the value ::");

		Map<String, Integer> mapDetails = hashmap.entrySet().stream().sorted(Comparator.comparingInt(e -> e.getValue()))
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (existing, replacement) -> existing, // Merge
																													// function
																													// in
																													// case
																													// of
																													// duplicate
																													// keys
						LinkedHashMap::new));// Map supplier to maintain order));
		
		
		System.out.println(mapDetails);

	}
}
