package com.algorithms.june.eighteen;

import java.util.ArrayList;
import java.util.List;

public class SumOfTwoLinkedList {

	private static SinglyNode headOne;
	private static SinglyNode headTwo;
	private static SinglyNode headOfSum;

	public static void main(String[] args) {

		List<Integer> listOne = new ArrayList<Integer>();
		listOne.add(2);
		listOne.add(4);
		listOne.add(7);
		listOne.add(1);

		List<Integer> listTwo = new ArrayList<Integer>();
		listTwo.add(9);
		listTwo.add(4);
		listTwo.add(5);

		headOne = createLinkedList(headOne, listOne);
		printLinkedList(headOne);
		headTwo = createLinkedList(headTwo, listTwo);
		printLinkedList(headTwo);

		headOfSum = sumOfTwoLinkedList(headOne, headTwo);
		printLinkedList(headOfSum);

	}

	private static SinglyNode sumOfTwoLinkedList(SinglyNode headOne, SinglyNode headTwo) {
		SinglyNode currentOne = headOne;
		SinglyNode currentTwo = headTwo;
		int num, carry = 0;
		while (currentOne != null || currentTwo != null) {
			int numOne = 0;
			int numTwo = 0;

			if (currentOne != null) {
				numOne = currentOne.data;
				currentOne = currentOne.next;
			}
			if (currentTwo != null) {
				numTwo = currentTwo.data;
				currentTwo = currentTwo.next;
			}
			num = numOne + numTwo + carry;
			carry = num / 10;
			num = num % 10;
			if (headOfSum == null) {
				headOfSum = new SinglyNode(num);
			} else {
				headOfSum.insert(num, headOfSum);
			}
		}
		return headOfSum;
	}

	private static SinglyNode createLinkedList(SinglyNode head, List<Integer> list) {

		for (Integer integer : list) {
			if (head == null) {
				head = new SinglyNode(integer);
			} else {
				head.insert(integer, head);
			}
		}
		return head;
	}

	private static void printLinkedList(SinglyNode head) {
		System.out.println();
		SinglyNode current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

}
