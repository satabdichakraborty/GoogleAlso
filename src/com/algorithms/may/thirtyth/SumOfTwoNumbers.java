package com.algorithms.may.thirtyth;

import java.util.Set;
import java.util.TreeSet;

public class SumOfTwoNumbers {

	public static void main(String[] args) {
		int[] arr = { 3, 5, -4, 8, 11, 1, -1, 6 };
		int target = 10;

		/*
		 * int[] retArr = testSumOfTwoNumbers_1(arr, target);
		 * 
		 * for (int i : retArr) { System.out.print(i + " "); }
		 */

		int[] retArr2 = testSumOfTwoNumbers_2(arr, target);

		for (int i : retArr2) {
			System.out.print(i + " ");
		}
	}

	private static int[] testSumOfTwoNumbers_2(int[] arr, int target) {
		Set<Integer> numbers = new TreeSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			int potentialMatch = target - arr[i];
			if (numbers.contains(potentialMatch)) {
				return new int[] { arr[i], potentialMatch };
			} else {
				numbers.add(arr[i]);
			}
		}
		return new int[0];
	}

	private static int[] testSumOfTwoNumbers_1(int[] arr, int target) {

		for (int i = 0; i < arr.length; i++) {
			int firstNum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				int secondNum = arr[j];
				if (firstNum + secondNum == target) {
					return new int[] { firstNum, secondNum };
				}
			}
		}
		return new int[0];
	}

}
