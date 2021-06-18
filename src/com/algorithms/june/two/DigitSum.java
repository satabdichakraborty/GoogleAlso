package com.algorithms.june.two;

public class DigitSum {

	public static void main(String[] args) {
		int num = 12345;

		int count = getDigitCountInNum(num);
		// System.out.println("Number of digits = " + count);
		int total = 0;

		/*
		 * for (int i = 0; i < count; i++) { total = total + getDigit(num, i); }
		 * System.out.println("Total = " + total);
		 */
		System.out.println("Total of 123 = " + getDigitSum(123));
		System.out.println("Total of 12345 = " + getDigitSum(12345));
		System.out.println("Total of 98765 = " + getDigitSum(98765));
	}

	private static int getDigitSum(int num) {
		int total = 0;
		while (num > 0) {
			total += num % 10;
			num /= 10;
		}

		return total;
	}

	// In order to get the digit at 10th position divide the number by 1 then modulo
	// 10
	// In order to get the digit at 100th position divide the number by 10 then
	// modulo 10
	// In order to get the digit at 1000th position divide the number by 100 then
	// modulo 10
	// In order to get the digit at 10000th position divide the number by 1000 then
	// modulo 10

	private static int getDigit(int num, int position) {
		/*
		 * int divisor = (int) (Math.pow(10, position)); num = num / divisor; int ret =
		 * (num % 10);
		 */
		// System.out.println("Returning num = " + ret + " at position = " + position);
		return num / (int) Math.pow(10, position) % 10;
	}

	private static int getDigitCountInNum(int num) {
		int count = 0;
		int temp = num;

		while (temp > 0) {
			temp = temp / 10;
			count++;
		}
		return count;
	}

}
