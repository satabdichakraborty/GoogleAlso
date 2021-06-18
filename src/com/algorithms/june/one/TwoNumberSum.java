package com.algorithms.june.one;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TwoNumberSum {

	private static int[] inputArray = new int[10];

	public static void main(String[] args) {

		Random random = new Random();
		int target = random.nextInt(10);

		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = random.nextInt(10);
		}

		System.out.println("Input Array : ");
		displayArrayData(inputArray);
		System.out.println("Target = " + target);

		int[] resultArray = findTheTwoNumbersSum(inputArray, target);
		boolean isTargetPresent = resultArray.length == 2 ? true : false;

		if (isTargetPresent) {
			System.out.println("Here is the target [" + target + "] and here are the numbers..");
			System.out.println("Output Array : ");
			displayArrayData(resultArray);
		}

	}

	private static void displayArrayData(int[] resultArray) {
		for (int i : resultArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int[] findTheTwoNumbersSum(int[] inputArray, int target) {
		Set<Integer> numbers = new TreeSet<Integer>();

		for (int i = 0; i < inputArray.length; i++) {
			int firstNumber = inputArray[i];
			int potential2ndNum = target - firstNumber;

			if (numbers.contains(potential2ndNum)) {
				return new int[] { firstNumber, potential2ndNum };
			} else {
				numbers.add(firstNumber);
			}
		}
		return new int[0];

	}

	private static int[] findTheTwoNumbersSum_way1(int[] inputArray, int target) {

		for (int i = 0; i < inputArray.length; i++) {
			int firstNumber = inputArray[i];
			for (int j = i + 1; j < inputArray.length; j++) {
				int secondNumber = inputArray[j];
				if ((firstNumber + secondNumber) == target) {
					return new int[] { firstNumber, secondNumber };
				}
			}
		}
		return new int[0];
	}

}
