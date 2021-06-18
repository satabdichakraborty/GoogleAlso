package com.algorithms.june.thirteen;

public class TestFib {

	public static void main(String[] args) {
		testFibPosition();
		testTillFibPosition();
	}

	private static void testTillFibPosition() {
		int position = 15;
		int i = 15;

		while (position >= 0) {
			System.out.println(i-- + " = [" + getFib(position--) + "] ");
		}
	}

	private static void testFibPosition() {
		int position = 0;
		System.out.println("Fib number at position [" + position + "]  = " + getFib(position));

		position = 1;
		System.out.println("Fib number at position [" + position + "]  = " + getFib(position));

		position = 5;
		System.out.println("Fib number at position [" + position + "]  = " + getFib(position));

		position = 10;
		System.out.println("Fib number at position [" + position + "]  = " + getFib(position));
	}

	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
	private static int getFib(int position) {
		if (position == 0) {
			return 0;
		} else if (position == 1) {
			return 1;
		} else {
			return getFib(position - 1) + getFib(position - 2);
		}
	}

}
