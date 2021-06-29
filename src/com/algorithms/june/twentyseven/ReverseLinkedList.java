package com.algorithms.june.twentyseven;

public class ReverseLinkedList {

	private static LinkedList head;

	public static void main(String[] args) {
		createdLinkedList();
		System.out.println("Before reversal");
		printLinkedList();
		head = reverseLinkedList();
		System.out.println("\nAfter reversal");
		printLinkedList();
	}

	private static LinkedList reverseLinkedList() {
		LinkedList p1 = null;
		LinkedList p2 = head;

		while (p2 != null) {
			LinkedList p3 = null;
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}

		return p1;
	}

	private static void printLinkedList() {
		LinkedList current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

	private static void createdLinkedList() {
		for (int i = 0; i < 11; i++) {
			if (head == null) {
				head = new LinkedList(i);
			} else {
				LinkedList current = head;
				while (current.next != null) {
					current = current.next;
				}
				current.next = new LinkedList(i);
			}
		}

	}

}
