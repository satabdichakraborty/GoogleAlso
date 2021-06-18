package com.algorithms.may.thirtyth;

public class Fibonacci {

	public static void main(String[] args) {
		int returnNum = getNthFibSum(5);
		System.out.println(returnNum);
	}

	public static int getNthFibSum(int n) {
		if (n == 2)
			return 1;
		else if (n == 1)
			return 0;
		else
			return getNthFibSum(n - 1) + getNthFibSum(n - 2);
	}

}
