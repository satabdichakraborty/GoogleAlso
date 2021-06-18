package com.algorithms.may.thirtyth;

import java.util.Arrays;
import java.util.Random;

//Array is sorted
//If the number is present return the index
//Otherwise Return -1
public class BinarySearch {

	public static void main(String[] args) {
		//int[] input = generateRandomSortedArray(10);
		//Random random = new Random();
		// int item = random.nextInt(5);

		// Failed testcase from algoexprt
		int[] input1 = { 1, 5, 23, 111 };
		// int item2 = 35;

		int[] testcase1 = { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
		int item = 22;
		// int index = binarySearch_Iterative(input, item);
		int index = binarySearch_recursive(testcase1, item);
		if (index != -1)
			System.out.println("Item [" + item + "] found at index = " + index);
		else
			System.out.println("Item [" + item + "] not found");

	}

	private static int binarySearch_recursive(int[] array, int target) {
		return binarySearch(array, 0, array.length, target);
	}

	private static int binarySearch(int[] input, int start, int end, int item) {
		if (start >= end) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (item == input[mid]) {

			return mid;

		} else if (item < input[mid]) {

			return binarySearch(input, 0, mid, item);

		} else {

			return binarySearch(input, mid + 1, end, item);

		}
	}

	private static int binarySearch_Iterative(int[] input, int item) {
		int halfPoint = (input.length) / 2;
		int returnIdx = -1;

		if (item < input[halfPoint]) {
			// Search the first half
			for (int i = 0; i < halfPoint; i++) {
				if (input[i] == item) {
					returnIdx = i;
				}
			}
		} else {
			// search the second half
			for (int i = halfPoint; i < input.length; i++) {
				if (input[i] == item) {
					returnIdx = i;
				}
			}
		}
		return returnIdx;
	}

	private static int[] generateRandomSortedArray(int capacity) {
		Random random = new Random();
		int i = 0;
		int[] input = new int[capacity];

		while (i < capacity) {
			input[i] = random.nextInt(20);
			i++;
		}
		Arrays.sort(input);

		for (int j : input) {
			System.out.print("[" + j + "]");
		}
		System.out.println();
		return input;
	}

}
