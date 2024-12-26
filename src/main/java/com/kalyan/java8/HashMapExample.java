package com.kalyan.java8;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Arrays;
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

		String str1 = "kalyan";
		String str2 = "nayalk";
		// create the HashMap
		if (str1.length() != str2.length()) {
			System.out.println("Strings are NOT In Anagaram::");
			return;
		}
		Map<Character, Integer> anagramHashMap = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			anagramHashMap.put(str1.charAt(i), anagramHashMap.getOrDefault(str1.charAt(i), 0) + 1);
		}
		for (int i = 0; i < str2.length(); i++) {
			char ch2 = str2.charAt(i);
			if (!anagramHashMap.containsKey(ch2)) {
				System.out.println("String are NOT IN anagaram");
				return;
			}
			anagramHashMap.put(ch2, anagramHashMap.get(ch2) - 1);

			if (anagramHashMap.get(ch2) < 0) {
				System.out.println("String are NOT IN anagaram");
				return;
			}
		}
		System.out.println("Strings are in ANAGARAM");

		System.out.println("Longest Substring Without Repeating Characters");
		String s = "abcabcbbkl";

//		Input: s = "abcabcbbkl"
//				Output: 3
		int maxCount = 0;
		int temp = maxCount;
		Map<Character, Integer> hashMapDetails = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!(hashMapDetails.containsKey(ch))) {
				hashMapDetails.put(ch, hashMapDetails.getOrDefault(ch, 0) + 1);
				temp++;

			} else {
				if (temp > maxCount) {
					maxCount = temp;
					temp = 0;
				}
			}

		}
		if (temp > maxCount) {
			maxCount = temp;
		}
		System.out.println(maxCount);

		System.out.println("Find Elements with Even Frequencies");
		Integer[] freqArray = { 1, 2, 2, 3, 3, 3, 4, 4 };
		List<Integer> freList = Arrays.asList(freqArray);
		List<Integer> collect2 = freList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() % 2 == 0).map(e -> e.getKey())
				.collect(Collectors.toList());
		System.out.println(collect2);
		System.out.println("Find Missing Numbers that are present in second Array ::: ");
		Integer[] nums1 = { 1, 2, 3 };
		Integer[] nums2 = { 1, 2, 2, 4, 10 };
		Map<Integer, Integer> missingHashMap = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			if (!missingHashMap.containsKey(nums1[i])) {
				missingHashMap.put(nums1[i], missingHashMap.getOrDefault(nums1[i], 0) + 1);
			}
			// System.out.println(missingHashMap);

		}
		for (int i = 0; i < nums2.length; i++) {
			if (!(missingHashMap.containsKey(nums2[i]))) {
				System.out.print(nums2[i] + " ");
			}
		}

	}

}
