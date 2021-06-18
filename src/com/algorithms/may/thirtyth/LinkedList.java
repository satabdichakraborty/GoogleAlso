package com.algorithms.may.thirtyth;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

public class LinkedList {

	private static Node root;

	public static void main(String[] args) {
		/* Testing insert and traverse method */
		// testInsertAndPrint();

		/*
		 * Testing deletion from an ASC linked List Example
		 * Root-->1-->1-->3-->4-->4-->4-->5-->6-->6-->null
		 */
		// testDeleteNodeFromASCList();

		/*
		 * Testing deletion from an empty linked List Example Root-->null
		 */
		// testEmptyRoot();

		/*
		 * Testing deletion from an random non-sorted linked List Example
		 * Example=Root-->5-->9-->9-->1-->4-->1-->9-->5-->1-->8-->null
		 */
		testDeleteNodeFromRandomist();
	}

	private static void testDeleteNodeFromRandomist() {

		testInsertAndPrint();
		Node current = root;

		Set<Integer> numbers = new TreeSet<Integer>();
		while (current != null) {
			numbers.add(current.data);
			current = current.next;
		}
		root = null;
		for (Integer integer : numbers) {
			insert(integer);
		}
		traverseLikedList();
	}

	private static void testEmptyRoot() {

		traverseLikedList();
		delete_ACS_list(1);
	}

	private static void testDeleteNodeFromASCList() {

		insert(1);insert(1);
		insert(3);
		insert(4);insert(4);insert(4);
		insert(5);
		insert(6);insert(6);
		// Test deleting 1 when the linked list starts with 1 as root

		System.out.println("Before Deleting 1");
		traverseLikedList();
		delete_ACS_list(1);
		System.out.println("After Deleting 1");
		traverseLikedList();

		// Test deleting 4 when the it's not at root value

		System.out.println("Before Deleting 4");
		traverseLikedList();
		delete_ACS_list(4);
		System.out.println("After Deleting 4");
		traverseLikedList();

		System.out.println("Before Deleting 6");
		traverseLikedList();
		delete_ACS_list(6);
		System.out.println("After Deleting 6");
		traverseLikedList();

	}

	private static void testInsertAndPrint() {
		Random random = new Random();
		int i = 0;
		while (i++ < 10) {
			insert(random.nextInt(10));
		}
		traverseLikedList();
	}

	public static void insert(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			Node current = root;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(data);
		}
	}

	public static void traverseLikedList() {
		Node current = root;
		System.out.println("Here are the nodes in linkedlist");
		System.out.print("Root-->");
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}

	public static void delete_ACS_list(int value) {
		Node current = root;
		if (root == null) {
			System.err.println("Empty linked list..");
			return;
		}
		// Values are sorted in ASC order and node to be deleted is at root node
		if (current.data == value) {
			while (current.next != null && current.next.data == value) {
				current = current.next;
			}
			root = current.next;
		} else {
			// Values are sorted in ASC order and value to be deleted in not at root node
			while (current.next != null && current.next.data != value) {
				current = current.next;
			}
			Node newStartNode = current;
			while (current.next != null && current.next.data == value) {
				current = current.next;
			}
			newStartNode.next = current.next;
		}
	}

}
