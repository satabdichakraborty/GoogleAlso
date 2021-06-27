package com.algorithms.june.eighteen;

public class SinglyLinkedList {

	private static SinglyNode head;

	public static void main(String[] args) {

		testInsert();
		testDelete();

	}

	public static void testDelete() {
		int target = 5;
		System.out.println("\nBefore delete [" + target + "]");
		testTraversal();
		if (head != null) {
			head = head.delete(target, head);
		}
		System.out.println("\nAfter delete [" + target + "]");
		testTraversal();

		target = 1;
		System.out.println("\nBefore delete [" + target + "]");
		testTraversal();

		if (head != null) {
			head = head.delete(target, head);
		}
		System.out.println("\nAfter delete [" + target + "]");
		testTraversal();
	}

	public static void testTraversal() {
		SinglyNode current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

	public static void insert(int target) {

		if (head == null) {
			head = new SinglyNode(target);
		} else {
			head.insert(target, head);
		}

	}

	private static void testInsert() {

		int target = -1;

		for (int i = 1; i < 10; i++) {
			target = i;
			insert(i);
		}
	}

}
