package com.algorithms.june.two;

public class NumberPalindrome {

	public static void main(String[] args) {
		System.out.println("is 123 Palindrome = " + isPalindrome(123));
		System.out.println("is 121 Palindrome = " + isPalindrome(121));

	}

	private static boolean isPalindrome(int num) {
		boolean isReverseSame = false;
		int receivedNum = num;
		int reverse = 0;

		while (receivedNum != 0) {
			reverse = (reverse * 10) + (receivedNum % 10);
			receivedNum = receivedNum / 10;

		}

		/*
		 * int count = 0; int temp = num; while (temp > 0) { temp /= 10; count++; }
		 * 
		 * int reverse = 0; while (count > 0) { reverse = reverse + (num % 10 * (int)
		 * (Math.pow(10, (count - 1)))); System.out.println("reverse = " + reverse); num
		 * = num/10; count--; }
		 */
		isReverseSame = num == reverse;
		return isReverseSame;
	}

}
