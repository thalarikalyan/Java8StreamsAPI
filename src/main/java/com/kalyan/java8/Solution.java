package com.kalyan.java8;

import java.util.Scanner;

public class Solution {

	private static boolean isPrime(int number) {
		int count = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				count++;
			}
		}
		return count == 2 ? true : false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		while (true) {

			if (isPrime(number)) {
				System.out.print(number);
				return;
			} else {
				number++;
			}

		}

	}

}
