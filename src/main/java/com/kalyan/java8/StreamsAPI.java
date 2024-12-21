package com.kalyan.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsAPI {

	public static void main(String[] args) {

		List<Integer> listOfIntegers = List.of(1, 5, 4, 2, 4, 6, 1, 9, 10, 2);

		// get duplicate values from the List

		List<Integer> collect = listOfIntegers.stream()
				.collect(Collectors.groupingBy(num -> num, Collectors.counting())) // {1=2,5=1,4=2,6=1,9=1,10=1,2=2}
				.entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey())
				.collect(Collectors.toList());

//		for (Map.Entry<Integer, Long> entry : groupOfIntegers.entrySet()) {
//			if(entry.getValue()>1) {
//				System.out.print(entry.getKey()+" ");
//			}
//			
//		}

		System.out.println(collect);

//		Map<Integer,Integer> hashMap=new HashMap<>();
//		hashMap.put(1, 1);
//		hashMap.put(1, 2);
//		hashMap.put(1, 3);
//		hashMap.put(2, 1);
//		hashMap.put(3, 2);
//		hashMap.put(4, 3);
//		System.out.println(hashMap); //{1=3, 2=1, 3=2, 4=3}
//		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//			Integer key = entry.getKey();
//			Integer val = entry.getValue();
//			
//		}
	}

}
