package com.algorithms.june.twentysix;

public class ReverseLinkedList {

	private static SinglyNode head;
	private static SinglyNode tail;

	public static void main(String[] args) {
		constructLinkedList();
		print(head);
		reverseIt();
		System.out.println();
		print(tail);

	}

	private static void constructLinkedList() {

		for (int i = 0; i < 10; i++) {
			insert(i);
		}

	}

	private static void reverseIt() {
		SinglyNode p1 = null;
		SinglyNode p2 = head;
		SinglyNode p3 = null;
		while (p2 != null) {
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		tail = p1;
	}

	private static void insert(int data) {
		SinglyNode current = head;

		if (current == null) {
			head = new SinglyNode(data);
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = new SinglyNode(data);
		}
	}

	private static void print(SinglyNode head) {
		SinglyNode current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

}
