package com.algorithms.may.thirtythone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

	public static void main(String[] args) {

		System.out.print("1-->");
		testCase1();// true
		System.out.print("2-->");
		testCase2();// true
		System.out.print("3-->");
		testCase3();// true
		System.out.print("4-->");
		testCase4();// true
		System.out.print("5-->");
		testCase5();// true
		System.out.print("6-->");
		testCase6();// true
		System.out.print("10-->");
		testCase10();// false
		System.out.print("13-->");
		testCase13();// false
	}

	// Time --> O(n) || Space --> O(1)
	public static boolean isValidSubsequence_1(List<Integer> array, List<Integer> sequence) {
		int arrayIndex = 0;
		int seqIndex = 0;

		while (arrayIndex < array.size() && seqIndex < sequence.size()) {
			if (array.get(arrayIndex).equals(sequence.get(seqIndex))) {
				seqIndex++;
			}
			arrayIndex++;
		}
		return seqIndex == sequence.size();
	}

	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		int seqIndex = 0;
		for (Integer integer : array) {
			if (seqIndex == sequence.size()) {
				break;
			}
			if (integer.equals(sequence.get(seqIndex))) {
				seqIndex++;
			}
		}
		return seqIndex == sequence.size();
	}

	private static void testCase1() {
		List<Integer> array = new ArrayList<Integer>();
		array.add(5);
		array.add(1);
		array.add(22);
		array.add(25);
		array.add(6);
		array.add(-1);
		array.add(8);
		array.add(10);

		List<Integer> sequence = new ArrayList<Integer>();
		sequence.add(1);
		sequence.add(6);
		sequence.add(-1);
		sequence.add(10);

		System.out.println(isValidSubsequence(array, sequence));
	}

	private static void testCase2() {
		Integer[] arr = { 5, 1, 22, 25, 6, -1, 8, 10 };
		List<Integer> array = Arrays.asList(arr);

		Integer[] seqs = { 1, 6, -1, 10 };
		List<Integer> sequence = Arrays.asList(seqs);

		System.out.println(isValidSubsequence(array, sequence));
	}

	private static void testCase3() {
		Integer[] arr = { 5, 1, 22, 25, 6, -1, 8, 10 };
		List<Integer> array = Arrays.asList(arr);

		Integer[] seqs = { 1 };
		List<Integer> sequence = Arrays.asList(seqs);

		System.out.println(isValidSubsequence(array, sequence));
	}

	private static void testCase4() {
		Integer[] arr = { 5, 1, 22, 25, 6, -1, 8, 10 };
		List<Integer> array = Arrays.asList(arr);

		Integer[] seqs = { 5, 1, 22, 25, 6, -1, 8, 10 };
		List<Integer> sequence = Arrays.asList(seqs);

		System.out.println(isValidSubsequence(array, sequence));
	}

	private static void testCase5() {
		Integer[] arr = { 5, 1, 22, 25, 6, -1, 8, 10 };
		List<Integer> array = Arrays.asList(arr);

		Integer[] seqs = { 1, 6, 10 };
		List<Integer> sequence = Arrays.asList(seqs);

		System.out.println(isValidSubsequence(array, sequence));
	}

	private static void testCase6() {
		Integer[] arr = {};
		List<Integer> array = Arrays.asList(arr);

		Integer[] seqs = {};
		List<Integer> sequence = Arrays.asList(seqs);

		System.out.println(isValidSubsequence(array, sequence));
	}

	private static void testCase10() {
		Integer[] arr = { 5, 1, 22, 25, 6, -1, 8, 10 };
		List<Integer> array = Arrays.asList(arr);

		Integer[] seqs = { 5, 1, 22, 25, 6, -1, 8, 10, 12 };
		List<Integer> sequence = Arrays.asList(seqs);

		System.out.println(isValidSubsequence(array, sequence));
	}

	private static void testCase13() {
		Integer[] arr = { 5, 1, 22, 25, 6, -1, 8, 10 };
		List<Integer> array = Arrays.asList(arr);

		Integer[] seqs = { 5, 1, 22, 22, 25, 6, -1, 8, 10 };
		List<Integer> sequence = Arrays.asList(seqs);

		System.out.println(isValidSubsequence(array, sequence));
	}

}
