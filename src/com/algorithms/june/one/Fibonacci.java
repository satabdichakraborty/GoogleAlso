package com.algorithms.june.one;

import java.util.Random;

public class Fibonacci {

	public static void main(String[] args) {

		Random random = new Random();
		int nthNum = random.nextInt(5);
		int num = getFibNumbers(nthNum);

		System.out.println(nthNum + " = " + num);

		int i = 0;
		System.out.println("Print fibs upto 20");
		while (i < 20) {
			System.out.print(getFibNumbers(i) + " ");
			i++;
		}
		System.out.println();
	}

	// 1-->0 2-->1 3-->1 4-->2 5-->3 6-->5 7-->8 8-->13 9-->21 10-->34
	// 11-->55 12-->89 13-->144 14-->233 15-->377 16-->610 17-->987 18-->1597
	// 19-->2584 20-->4181
	private static int getFibNumbers(int number) {
		if (number == 0) {
			return 0;
		} else if (number == 1) {
			return 1;
		} else {
			return getFibNumbers(number - 2) + getFibNumbers(number - 1);
		}

	}

}
