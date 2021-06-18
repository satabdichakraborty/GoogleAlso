package com.algorithms.june.seventeen;

public class TestLinkedList {

	private static Node head;

	public static void main(String[] args) {
		testInsert();
		testSize();
		testTraversal();
		testDelete();
		testSize();
		testTraversal();

	}

	private static void testSize() {
		int size = head != null ? head.size : 0;
		System.out.println("\nLinked List size = " + size);
	}

	private static void testDelete() {
		int target = 40;
		if (head != null) {
			head = head.delete(head, target);
		}
		target = 10;
		if (head != null) {
			head = head.delete(head, target);
		}

		target = 60;
		if (head != null) {
			head = head.delete(head, target);
		}
		target = 70;
		if (head != null) {
			head = head.delete(head, target);
		}

	}

	private static void testTraversal() {
		if (head != null) {
			head.traverseNodes(head);
		}

	}

	private static void testInsert() {
		int target = 10;

		if (head == null) {
			head = new Node(target);
		}
		target = 20;
		head = head.insert(head, target);
		target = 30;
		head = head.insert(head, target);
		target = 40;
		head = head.insert(head, target);
		target = 50;
		head = head.insert(head, target);
		target = 60;
		head = head.insert(head, target);
	}

}
