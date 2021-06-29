package com.algorithms.june.twentyeight;

public class ReverseALinkedList {

	private static LinkedList head = null;

	public static void main(String[] args) {
		createLikedList();
		System.out.println("Before reversal");
		print();
		reverseIt();
		System.out.println("\nAfter reversal");
		print();
	}

	private static void reverseIt() {
		LinkedList p1 = null;
		LinkedList p2 = head;
		LinkedList p3 = null;
		while (p2 != null) {
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		head = p1;
	}

	private static void print() {
		LinkedList current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");

	}

	private static void createLikedList() {
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
