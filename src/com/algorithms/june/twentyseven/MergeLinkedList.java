package com.algorithms.june.twentysix;

import java.util.ArrayList;
import java.util.List;

class LinkedList {
	int value;
	LinkedList next;

	LinkedList(int value) {
		this.value = value;
		this.next = null;
	}

	@Override
	public String toString() {
		return "LinkedList [value=" + value + ", next=" + next + "]";
	}
}

public class MergeLinkedList {

	private static LinkedList headOne;
	private static LinkedList headTwo;
	private static LinkedList headMerged;

	public static void main(String[] args) {
		System.out.println("LinkedList One -->");
		List<Integer> listOne = new ArrayList<Integer>();
		listOne.add(2);
		listOne.add(4);
		listOne.add(6);
		listOne.add(8);
		headOne = createLinkedList(headOne, listOne);
		printLinkedList(headOne);

		System.out.println("\nLinkedList Two -->");
		List<Integer> listTwo = new ArrayList<Integer>();
		listTwo.add(1);
		listTwo.add(3);
		listTwo.add(5);
		listTwo.add(7);
		listTwo.add(9);
		listTwo.add(10);
		headTwo = createLinkedList(headTwo, listTwo);
		printLinkedList(headTwo);

		System.out.println("\nMerged LinkedList -->");
		headMerged = mergeLinkedLists(headOne, headTwo);
		printLinkedList(headMerged);
	}

	public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
		LinkedList prev = null;
		LinkedList p1 = headOne;
		LinkedList p2 = headTwo;

		while (p1 != null && p2 != null) {
			if (p1.value < p2.value) {
				prev = p1;
				p1 = p1.next;
			} else {
				if (prev != null) {
					prev.next = p2;
				}
				prev = p2;
				p2 = p2.next;
				prev.next = p1;
			}
		}
		if (p1 == null) {
			prev.next = p2;
		}
		return headOne.value < headTwo.value ? headOne : headTwo;
	}

	private static LinkedList createLinkedList(LinkedList head, List<Integer> list) {

		for (Integer value : list) {
			if (head == null) {
				head = new LinkedList(value);
			} else {
				LinkedList current = head;
				while (current.next != null) {
					current = current.next;
				}
				current.next = new LinkedList(value);
			}
		}
		return head;
	}

	private static void printLinkedList(LinkedList head) {
		LinkedList current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");

	}
}
