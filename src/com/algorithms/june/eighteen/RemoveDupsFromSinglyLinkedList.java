package com.algorithms.june.eighteen;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDupsFromSinglyLinkedList {

	private static SinglyNode head;

	public static void main(String[] args) {

		testRemovingDupsFromSortedList();
		testRemovingDupsFromUnSortedList();

	}

	private static void testRemovingDupsFromUnSortedList() {
		createUnsortedLinkedListWithDups();
		traverseList();
		removeDupsFromUnsortedLinkedList();
		traverseList();

	}

	private static void removeDupsFromUnsortedLinkedList() {
		Set<Integer> unsortedList = new TreeSet<Integer>();
		SinglyNode current = head;
		while (current != null) {
			unsortedList.add(current.data);
			current = current.next;
		}
		head = null;
		for (Integer integer : unsortedList) {
			if (head == null) {
				head = new SinglyNode(integer);
			} else {
				head.insert(integer, head);
			}
		}

	}

	private static void testRemovingDupsFromSortedList() {
		createLinkedListWithDups();
		traverseList();
		removeDupsFromSortedLinkedList();
		traverseList();
	}

	private static void removeDupsFromSortedLinkedList() {
		SinglyNode current = head;
		SinglyNode previous = null;
		while (current != null) {
			previous = current;
			while (current.next != null && current.data == current.next.data) {
				current = current.next;
			}
			previous.next = current.next;
			current = current.next;
		}

	}

	private static void createLinkedListWithDups() {
		int target = 1;
		if (head == null) {
			head = new SinglyNode(target);
		}

		target = 1;
		head.insert(target, head);
		target = 2;
		head.insert(target, head);
		target = 3;
		head.insert(target, head);
		target = 4;
		head.insert(target, head);
		target = 4;
		head.insert(target, head);
		target = 4;
		head.insert(target, head);
		target = 5;
		head.insert(target, head);
		target = 6;
		head.insert(target, head);
		target = 6;
		head.insert(target, head);

	}

	private static void createUnsortedLinkedListWithDups() {
		int target = 9;
		if (head == null) {
			head = new SinglyNode(target);
		}

		target = 8;
		head.insert(target, head);
		target = 8;
		head.insert(target, head);
		target = 1;
		head.insert(target, head);
		target = 1;
		head.insert(target, head);
		target = 2;
		head.insert(target, head);
		target = 3;
		head.insert(target, head);
		target = 4;
		head.insert(target, head);
		target = 4;
		head.insert(target, head);
		target = 4;
		head.insert(target, head);
		target = 6;
		head.insert(target, head);
		target = 7;
		head.insert(target, head);
		target = 6;
		head.insert(target, head);

	}

	private static void traverseList() {
		System.out.println();
		SinglyNode current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

}
