package com.algorithms.june.one;

public class OperatorPrecedence {

	public static void main(String[] args) {
		double firstDoubleVar = 20.00;
		double secondDoubleVar = 80.00;

		double total = (firstDoubleVar + secondDoubleVar) * 100;

		double remainder = total % 40;
		boolean isTheRemainderZero = (remainder == 0) ? true : false;
		
		System.out.println("isTheRemainderZero = "+isTheRemainderZero);
	}

}
