package com.algorithms.june.seventeen;

public class RemoveKthNodeFromEnd {

	private static Node head;

	public static void main(String[] args) {

		System.out.println("Before removig the kth node");
		createList();
		printList();
		System.out.println("\nAfter removig the kth node");
		removeKthNode();
		printList();

	}

	private static void removeKthNode() {
		int target = 5;
		int temp = target;
		Node previous = null;
		Node pointerOne = head;
		Node pointerTwo = head;

		while (pointerOne != null && temp > 0) {
			pointerOne = pointerOne.next;
			temp--;
		}

		while (pointerOne != null) {
			previous = pointerTwo;
			pointerTwo = pointerTwo.next;
			pointerOne = pointerOne.next;			
		}
		previous.next = pointerTwo.next;

	}

	private static void createList() {
		int target = 0;

		if (head == null) {
			head = new Node(target);
		}
		target = 1;
		head = head.insert(head, target);
		target = 2;
		head = head.insert(head, target);
		target = 3;
		head = head.insert(head, target);
		target = 4;
		head = head.insert(head, target);
		target = 5;
		head = head.insert(head, target);
		target = 6;
		head = head.insert(head, target);
		target = 7;
		head = head.insert(head, target);
		target = 8;
		head = head.insert(head, target);
		target = 9;
		head = head.insert(head, target);
	}

	private static void printList() {
		Node current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

}
