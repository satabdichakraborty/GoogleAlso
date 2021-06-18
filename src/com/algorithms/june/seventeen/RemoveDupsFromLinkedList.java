package com.algorithms.june.seventeen;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDupsFromLinkedList {

	private static Node head;

	public static void main(String[] args) {

		// Testing removing dups from sorted list
		System.out.println("Before removal from sorted list");
		createSortedList();
		printList();
		System.out.println("After removal");
		removeDupsFromSortedList();
		printList();

		// Testing removing dups from unsorted list
		System.out.println("\nBefore removal from unsorted list");
		createUnsortedList();
		printList();
		System.out.println("After removal");
		removeDupsFromUnsortedList();
		printList();

	}

	private static void createUnsortedList() {
		int target = 1;

		if (head == null) {
			head = new Node(target);
		}
		target = 9;
		head = head.insert(head, target);
		target = 9;
		head = head.insert(head, target);
		target = 4;
		head = head.insert(head, target);
		target = 1;
		head = head.insert(head, target);
		target = 4;
		head = head.insert(head, target);
		target = 5;
		head = head.insert(head, target);
		target = 3;
		head = head.insert(head, target);
		target = 6;
		head = head.insert(head, target);
		target = 7;
		head = head.insert(head, target);
		target = 2;
		head = head.insert(head, target);
	}

	private static void removeDupsFromUnsortedList() {
		Set<Integer> list = new TreeSet<Integer>();

		Node current = head;
		while (current != null) {
			list.add(current.data);
			current = current.next;
		}

		int i = list.size() - 1;

		head = null;
		for (Integer integer : list) {
			if (head == null) {
				head = new Node(integer);
			} else {
				head = head.insert(head, integer);
			}
		}

	}

	private static void removeDupsFromSortedList() {
		Node current = head;
		Node previous = null;
		while (current != null) {
			previous = current;
			while (current.next != null && current.data == current.next.data) {
				current = current.next;
			}
			previous.next = current.next;
			current = current.next;
		}
	}

	private static void createSortedList() {
		int target = 1;

		if (head == null) {
			head = new Node(target);
		}
		target = 1;
		head = head.insert(head, target);
		target = 3;
		head = head.insert(head, target);
		target = 4;
		head = head.insert(head, target);
		target = 4;
		head = head.insert(head, target);
		target = 4;
		head = head.insert(head, target);
		target = 5;
		head = head.insert(head, target);
		target = 6;
		head = head.insert(head, target);
		target = 6;
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
		System.out.println();
	}

}
