package com.kalyan.java8;

import java.util.*;

public class ComputeIfAbsentExample {
    public static void main(String[] args) {
        HashMap<Character, ArrayList<String>> groupedItems = new HashMap<>();
        List<String> items = Arrays.asList("Apple", "Banana", "Avocado", "Blueberry");

        // Group items by their starting letter
        for (String item : items) {
            char key = item.charAt(0); // Get the first character as the key
            groupedItems.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
        }

        // Print the grouped items
        groupedItems.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

