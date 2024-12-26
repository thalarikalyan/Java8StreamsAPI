package com.kalyan.java8;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class HashMapExample {

	public static void main(String[] args) {
		String name = "Kalyan Thalari";
		Map<Character, Integer> hashMap = new LinkedHashMap<>();
		// loop the string
		for (int i = 0; i < name.length(); i++) {
			hashMap.put(name.charAt(i), hashMap.getOrDefault(name.charAt(i), 0) + 1);
		}
//		for(Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
//			if (entry.getValue() != 1) {
//				System.out.print(entry.getKey() + " ");
//			}
//		}
		List<Character> listOfCharacters = hashMap.entrySet().stream()
				.filter(entry -> entry.getValue() == 1 && !(entry.getKey().equals(' '))).map(entry -> entry.getKey())
				.collect(Collectors.toList());
		System.out.println("Unique Characters is ::" + listOfCharacters);

		// Given an array and a number sum, check if there is a pair with the given sum
		// using a HashMap.
		System.out.println("Given an array and a number sum, check if there is a pair with the given sum");
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int total = 9; // map = {10: 1, 15: 1, 3: 1}.
		Map<Integer, Integer> map1 = new HashMap<>();
		boolean flag = false;
		for (int a1 : a) {
			int complement = total - a1;
			if (map1.containsKey(complement)) {
				flag = true;
				break;
			}
			map1.put(a1, 1);

		}
		System.out.println(flag ? "Pair is found ::" : "Pair is NOT Found ::");

		System.out.println("Find the First Non-Repeating Character:::");
		List<Character> collect = hashMap.entrySet().stream()
				.filter(entry -> entry.getValue() == 1 && !(entry.getKey().equals(' '))).map(entry -> entry.getKey())
				.collect(Collectors.toList());
		System.out.println(collect.get(0));

		System.out.println("Check Anagrams Using the HashMap");

		String str1 = "lksten";
		String str2 = "sllent";
		// create the HashMap
		if (str1.length() != str2.length()) {
			System.out.println("Strings are NOT In Anagaram::");
			return;
		}
		Map<Character, Integer> anagramHashMap = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			anagramHashMap.put(str1.charAt(i), anagramHashMap.getOrDefault(str1.charAt(i), 0) + 1);
		}
		for(int i=0;i<str2.length();i++) {
			char ch2=str2.charAt(i);
			if(!anagramHashMap.containsKey(ch2)) {
				System.out.println("String are NOT IN anagaram");
				return;
			}
			anagramHashMap.put(ch2, anagramHashMap.get(ch2)-1);
			
			 if (anagramHashMap.get(ch2) < 0) {
				 System.out.println("String are NOT IN anagaram");
					return;
	            }
		}
		System.out.println("Strings are in ANAGARAM");

	}

}
