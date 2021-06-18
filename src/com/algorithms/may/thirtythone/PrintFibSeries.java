package com.algorithms.may.thirtythone;

public class PrintFibSeries {

	public static void main(String[] args) {
		int index = 0;
		int number = 5;

		while (index <= number) {
			System.out.print(index +" = ["+getFibNumber(index) + "] ");
			index++;
		}
		System.out.println();
		System.out.println(number+"th FibNumber is "+getFibNumber(number));
	}

	private static int getFibNumber(int index) {
		if (index == 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else {
			return getFibNumber(index - 1) + getFibNumber(index - 2);
		}
	}
}
