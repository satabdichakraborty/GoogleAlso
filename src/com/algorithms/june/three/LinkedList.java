package com.algorithms.june.three;

class Node {

	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

}

public class LinkedList {

	private static Node head;
	private static Node tail;

	public static void main(String[] args) {

		insertAtFront(0);
		insertAtEnd(10);
		insertAtEnd(20);
		insertAtEnd(30);
		insertAtEnd(40);
		insertAtEnd(50);
		insertAtEnd(60);

		System.out.println("Looking for node index with value 50 = " + nodeIndex(50));

		System.out.println();
		display();
		delete(30);
		System.out.println("\nAfter deleting 30");
		display();
		delete(10);
		System.out.println("\nAfter deleting 10");
		display();

		System.out.println("\nLooking for node index with value 50 = " + nodeIndex(50));

		System.out.println("Inserting 70 at end using tail");
		insertAtEndUsingTail(70);
		display();

	}

	private static int nodeIndex(int value) {
		Node current = head;
		int size = 0;

		while (current != null && current.data != value) {
			current = current.next;
			size++;
		}
		return size + 1;
	}

	// This delete is assuming there are no dups in the list
	private static void delete(int value) {
		Node current = head;
		Node toBeDeleted = null;
		if (head != null && head.data == value) {
			current = current.next;
			head = current;
		} else {
			while (current.next != null && current.next.data != value) {
				current = current.next;
			}
			toBeDeleted = current.next;
			current.next = toBeDeleted.next;
		}
	}

	private static void insertAtFront(int value) {
		Node current = head;

		Node newNode = new Node(value);
		if (head == null) {
			head = new Node(value);
			tail = head;
		} else {
			head = newNode;
			newNode.next = current.next;
		}
	}

	private static void insertAtEndUsingTail(int value) {
		if (tail != null)
			tail.next = new Node(value);
	}

	private static void insertAtEnd(int value) {
		Node current;
		current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(value);
	}

	private static void display() {
		Node current = head;
		System.out.print("head-->");
		while (current != null) {
			tail = current;
			System.out.print(current.data + "-->");
			current = current.next;			
		}

		System.out.print("null");
	}

}
