package com.algorithms.june.seventeen;

import java.util.ArrayList;
import java.util.List;

public class SumOfTwoLinkedList {

	private static Node headOne;
	private static Node headTwo;
	private static Node headOfSum;

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(4);
		list1.add(7);
		list1.add(1);
		headOne = createLinkedList(headOne, list1);
		headOne.traverseNodes(headOne);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(9);
		list2.add(4);
		list2.add(5);
		headTwo = createLinkedList(headTwo, list2);
		headTwo.traverseNodes(headTwo);

		headOfSum = sumOfTwoLinkedList(headOne, headTwo);
		headOfSum.traverseNodes(headOfSum);

	}

	private static Node sumOfTwoLinkedList(Node headOne, Node headTwo) {
		Node headOneCurrent = headOne;
		Node headTwoCurrent = headTwo;
		int sum, num, carry = 0;
		while (headOneCurrent != null || headTwoCurrent != null) {
			int one = headOneCurrent != null ? headOneCurrent.data : 0;
			int two = headTwoCurrent != null ? headTwoCurrent.data : 0;
			sum = one + two + carry;
			carry = sum / 10;
			num = sum % 10;
			if (headOfSum == null) {
				headOfSum = new Node(num);
			} else {
				headOfSum = headOfSum.insert(headOfSum, num);
			}
			if (headOneCurrent != null) {
				headOneCurrent = headOneCurrent.next;
			}
			if (headTwoCurrent != null) {
				headTwoCurrent = headTwoCurrent.next;
			}

		}
		return headOfSum;
	}

	private static Node createLinkedList(Node head, List<Integer> list) {

		for (Integer integer : list) {
			if (head == null) {
				head = new Node(integer);
			} else {
				head = head.insert(head, integer);
			}
		}
		return head;
	}

}
