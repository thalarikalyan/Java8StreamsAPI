package com.kalyan.java8;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		String name=sc.next();
		Character secondRepeatedCharacter = name.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).map(e -> e.getKey()).skip(1).findFirst().get();
		System.out.println(secondRepeatedCharacter);

	}

}
