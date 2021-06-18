package com.algorithms.june.one;

class Node {
	int data;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

}

public class LinkedListTest {

	private static Node head;

	public static void main(String[] args) {

		insert(10);
		insert(20);
		insert(30);
		insert(40);
		insert(50);
		insert(60);
		insert(70);
		insert(80);
		insert(90);
		printLinkedList();

		delete(40);
		printLinkedList();

		delete(10);
		printLinkedList();

		delete(60);
		printLinkedList();

		delete(80);
		printLinkedList();

	}

	public static void delete(int value) {
		Node current = null;
		Node nodeToBoDeleted = null;
		if (head == null) {
			System.out.println("Linked List is empty..");
		} else {
			if (head != null && head.data == value) {
				current = head;
				head = current.next;

			} else {
				current = head;
				while (current.next != null && current.next.data != value) {
					current = current.next;
				}
				nodeToBoDeleted = current.next;
				current.next = nodeToBoDeleted.next;
			}
		}
	}

	public static void insert(int value) {
		Node current = null;
		if (head == null) {
			head = new Node(value);
		} else {
			current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(value);
		}
	}

	public static void printLinkedList() {
		Node current = head;

		System.out.print("Head -->");
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}

}
