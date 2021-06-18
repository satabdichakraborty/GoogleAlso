package com.algorithms.june.three;

import java.util.Set;
import java.util.TreeSet;

class LinkedListNode {
	int data;
	LinkedListNode next;

	LinkedListNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

}

public class RemoveDupsFromLinkedList {

	private static LinkedListNode head;

	public static void main(String[] args) {
		head = new LinkedListNode(1);
		insertAtEnd(1);
		insertAtEnd(3);
		insertAtEnd(4);
		insertAtEnd(4);
		insertAtEnd(4);
		insertAtEnd(5);
		insertAtEnd(6);
		insertAtEnd(6);
		displayLinkedList();
		System.out.println();
		// removeDups();
		removeRandomDups();
		displayLinkedList();
		System.out.println();
	}

	// This method removes dup nodes when nodes are in ASC order
	private static void removeDups() {
		LinkedListNode current = head;

		while (current != null) {
			LinkedListNode lastDistinctNode = current;
			while (current.next != null && current.data == current.next.data) {
				current = current.next;
			}
			LinkedListNode nextDistinctNode = current.next;
			lastDistinctNode.next = nextDistinctNode;
			current = current.next;
		}

	}

	// This method removes dup nodes when nodes are not in any order
	private static void removeRandomDups() {
		LinkedListNode current = head;
		LinkedListNode lastDistinctNode = null;
		Set<Integer> numbers = new TreeSet<Integer>();

		while (current != null) {
			if (numbers.add(current.data)) {
				lastDistinctNode = current;
				current = current.next;
			} else {
				lastDistinctNode.next = current.next;
				current = current.next;
			}
		}
	}

	private static boolean isEmpty() {
		return head == null;
	}

	private static void insertAtEnd(int data) {
		LinkedListNode current = head;
		if (isEmpty()) {
			head = new LinkedListNode(data);
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = new LinkedListNode(data);
		}
	}

	private static void displayLinkedList() {
		LinkedListNode current = head;
		if (isEmpty()) {
			System.out.print("LinkedList is empty");
		} else {
			System.out.println("Head -->");
			while (current != null) {
				System.out.print(current.data + "-->");
				current = current.next;
			}
			System.out.print("null");
		}

	}

}
