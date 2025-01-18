package com.kalyan.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strings_In_Java8 {

	public static void main(String[] args) {

		// welcome-- second non repeating character

//		Map<Character, Integer> hashMap = new LinkedHashMap<>();
//		for (int i = 0; i < s.length(); i++) {
//			hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
//		}
//		int count = 0;
//		System.out.println(hashMap);
//		for (Entry<Character, Integer> hasMapValue : hashMap.entrySet()) {
//			if (hasMapValue.getValue() == 1) {
//				count++;
//
//			}
//			if (count == 2) {
//				System.out.println(hasMapValue.getKey());
//				return;
//			}
//		}
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		Character secondNonRepeatedCharacter = name.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).map(e -> e.getKey()).skip(1).findFirst().get();
		System.out.println(secondNonRepeatedCharacter);
		System.out.println("Find out Second Repeated Characters in Given String:: ");

		// Steps What I done above

//		1. converted String to chars
//		2. convert each character to Character Object
//		3. Now I followed regular procedure of Streams

		Optional<Character> secondRepeatedCharacter = name.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(c -> c.getValue() > 1).map(c -> c.getKey()).skip(1).findFirst();
		if (secondRepeatedCharacter.isPresent()) {
			System.out.println(secondRepeatedCharacter.get());
		} else {
			System.out.println("No Second Character is Found ::");

		}

		List<String> strings = Arrays.asList("cat", "elephant", "dog", "tiger");
		System.out.println("Find biggest word ");
		String maxWord = strings.stream().collect(Collectors.toMap(Function.identity(), s -> s.length())).entrySet().stream().max(Entry.comparingByValue()).map(t ->t.getKey() ).get();
		System.out.println(maxWord);
//		String maxWord1 = strings.stream()
//                .collect(Collectors.toMap(Function.identity(), String::length)) // Map words to their lengths
//                .entrySet()
//                .stream()
//                .sorted(Comparator.comparing(Entry.<String, Integer>comparingByValue()).reversed()) // Sort by value (length) descending
//                .findFirst() // Get the first entry (longest word)
//                .map(Entry::getKey) // Extract the word (key)
//                .orElse(""); // Default to empty string if the stream is empty
//
//        System.out.println(maxWord1);  // Output: elephant --error at comparing()

	}

}
