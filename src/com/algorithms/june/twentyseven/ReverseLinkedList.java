package com.algorithms.june.twentyseven;

class SingleLinkedList {
	int value;
	SingleLinkedList next;

	SingleLinkedList(int value) {
		this.value = value;
		this.next = null;
	}
}

public class ReverseLinkedList {

	private static SingleLinkedList head;

	public static void main(String[] args) {
		createdLinkedList();
		System.out.println("Before reversal");
		printLinkedList();
		head = reverseLinkedList();
		System.out.println("\nAfter reversal");
		printLinkedList();
	}

	private static SingleLinkedList reverseLinkedList() {
		SingleLinkedList p1 = null;
		SingleLinkedList p2 = head;

		while (p2 != null) {
			SingleLinkedList p3 = null;
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}

		return p1;
	}

	private static void printLinkedList() {
		SingleLinkedList current = head;
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
				head = new SingleLinkedList(i);
			} else {
				SingleLinkedList current = head;
				while (current.next != null) {
					current = current.next;
				}
				current.next = new SingleLinkedList(i);
			}
		}

	}

}
