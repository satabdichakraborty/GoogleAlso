package com.algorithms.june.four;

public class SumOfTwoLinkedList {

	public static void main(String[] args) {
		LinkedList linkedListOne = new LinkedList(2);
		linkedListOne = linkedListOne.insert(linkedListOne, 4);
		linkedListOne = linkedListOne.insert(linkedListOne, 7);
		linkedListOne = linkedListOne.insert(linkedListOne, 1);

		linkedListOne.display(linkedListOne);
		System.out.println();

		LinkedList linkedListTwo = new LinkedList(9);
		linkedListTwo = linkedListTwo.insert(linkedListTwo, 4);
		linkedListTwo = linkedListTwo.insert(linkedListTwo, 5);

		linkedListTwo.display(linkedListTwo);
		System.out.println();

		LinkedList linkedListSum = sumOfLinkedLists(linkedListOne, linkedListTwo);
		linkedListSum.display(linkedListSum);
		System.out.println();
	}

	public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
		LinkedList pointer1 = linkedListOne;
		LinkedList pointer2 = linkedListTwo;

		int listOneTotal = getTotal(pointer1);
		System.out.println("linkedListOne total = " + listOneTotal);

		int listTwoTotal = getTotal(pointer2);
		System.out.println("linkedListOne total = " + listTwoTotal);

		int sum = listOneTotal + listTwoTotal;
		System.out.println("Sum = " + sum);

		int temp = sum;
		temp = temp % 10;
		LinkedList linkedListSum = new LinkedList(temp);
		temp = sum / 10;
		while (temp > 0) {
			int value = temp % 10;
			linkedListSum = linkedListSum.insert(linkedListSum, value);
			temp = temp / 10;
		}

		return linkedListSum;
	}

	private static int getTotal(LinkedList list) {
		int listOneTotal = 0;
		int counter = 0;
		while (list != null) {
			listOneTotal += ((int) Math.pow(10, counter++)) * (list.value);
			list = list.next;
		}
		return listOneTotal;
	}

}
