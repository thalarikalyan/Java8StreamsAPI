package com.kalyan.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagaram {

	public static void main(String[] args) {
		String[] groupOfAnagarams = { "eat", "tea", "ate", "tan", "nat", "bat" };

		Map<String, List<String>> hashMap = new HashMap<>();

		for (String values : groupOfAnagarams) {

			// convert to Array
			char[] valuesArray = values.toCharArray();
			Arrays.sort(valuesArray);
			String s = new String(valuesArray);// aet
			if (hashMap.get(s) == null) {
				hashMap.put(s, new ArrayList<>());
			}
			hashMap.get(s).add(values);

		}
		List<List<String>> list = hashMap.entrySet().stream().map(entry -> entry.getValue()).toList();
		System.out.println(list);

	}

}
