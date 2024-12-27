package com.kalyan.java8;

import java.util.HashSet;

public class SubarrayWithZeroSum {
	public static void main(String[] args) {
		int[] arr = { 4, 2, -3, 1, 6 };
		System.out.println(hasZeroSumSubarray(arr)); // Output: true
	}

	public static boolean hasZeroSumSubarray(int[] arr) {
		// Set to store prefix sums
		HashSet<Integer> prefixSums = new HashSet<>();
		int prefixSum = 0;

		for (int num : arr) {
			prefixSum += num;

			// Check if prefix sum is 0 or already exists in the set
			if (prefixSum == 0 || prefixSums.contains(prefixSum)) {
				return true;
			}

			// Add current prefix sum to the set
			prefixSums.add(prefixSum);
		}

		// No subarray with sum 0 found
		return false;
	}
}
