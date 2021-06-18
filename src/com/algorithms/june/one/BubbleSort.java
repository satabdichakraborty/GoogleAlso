package com.algorithms.june.one;

import java.util.Random;

public class BubbleSort {

	private static int[] bubbleArray = new int[10];

	public static void main(String[] args) {

		Random random = new Random();

		for (int i = 0; i < bubbleArray.length; i++) {
			bubbleArray[i] = random.nextInt(20);
		}

		bubbleSort(bubbleArray);
		displayArrayData();
	}

	private static void bubbleSort(int[] bubbleArray) {

		int sortedPosition = bubbleArray.length;
		boolean swap = false;

		while (sortedPosition > 0 && !swap) {
			swap = true;
			for (int i = 0; i < sortedPosition - 1; i++) {
				if (bubbleArray[i] > bubbleArray[i + 1]) {
					swap(i, (i + 1));
					swap = false;
				}
			}
			sortedPosition--;
		}
	}

	private static void swap(int i, int j) {
		int temp = bubbleArray[i];
		bubbleArray[i] = bubbleArray[i + 1];
		bubbleArray[i + 1] = temp;

	}

	private static void displayArrayData() {
		for (int i : bubbleArray) {
			System.out.print(i + " ");
		}
	}

}
