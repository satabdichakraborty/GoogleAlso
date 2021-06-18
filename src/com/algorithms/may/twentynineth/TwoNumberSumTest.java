package com.algorithms.may.twentynineth;

import java.util.HashSet;
import java.util.Set;

public class TwoNumberSumTest {

	public static void main(String[] args) {
		int[] arr = { 3, 5, -4, 8, 11, 1, -1, 6 };

		int[] output = twoNumberSum_2(arr, 10);

		for (int k : output) {
			System.out.print(k + " ");
		}
	}

	public static int[] twoNumberSum(int[] array, int targetSum) {
		int i = 0;
		while (i < array.length) {
			int firstNum = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int secondNum = array[j];
				if ((firstNum + secondNum) == targetSum) {
					return new int[] { firstNum, secondNum };
				}
			}
			i++;
		}
		return new int[0];
	}

	public static int[] twoNumberSum_2(int[] array, int targetSum) {
		Set<Integer> nums = new HashSet<Integer>();
		for (int val : array) {
			int potentialMatch = targetSum - val;

			if (nums.contains(potentialMatch)) {
				return new int[] { val, potentialMatch };
			} else {
				nums.add(val);
			}
		}
		return new int[0];
	}

}
