package com.algorithms.may.thirtyth;

public class Bubble {

	public static void main(String[] args) {
		int[] array = { 5, 7, 1, 8, 3, 9, 2, 4, 6, 6 };

		bubbleSort(array);
	}

	private static void bubbleSort(int[] array) {
		int sortedPosition = array.length;

		while (sortedPosition > 0) {
			for (int i = 0; i < sortedPosition - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
			sortedPosition--;
		}
		
		for (int i : array) {
			System.out.print(i+" ");
		}

	}

}
