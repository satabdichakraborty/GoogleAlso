package com.algorithms.may.twentynineth;

import java.util.Hashtable;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDupsFromLinkedList {

	public static class LinkedList {
		int value;
		LinkedList next;

		public LinkedList(int value) {
			this.value = value;
		}
	}

	private static LinkedList root;

	public static void main(String[] args) {

		Random random = new Random();
		/*
		 * int i = 0; while (i++ < 10) { insert(random.nextInt(15)); }
		 */

		insert(1);
		insert(1);
		insert(3);
		insert(4);
		insert(4);
		insert(4);
		insert(5);
		insert(6);
		insert(6);
		printList();
		System.out.println("Using method -- removeDups_two");
		removeDups_two();
		
		System.out.println("Using method -- removeDups_sets");
		removeDups_sets();
		printList();
	}

	private static void removeDups_two() {
		LinkedList current = root;
		while (current != null) {
			LinkedList nextDistinctNode = current.next;
			while (nextDistinctNode != null && current.value == nextDistinctNode.value) {
				nextDistinctNode = nextDistinctNode.next;
			}
			current.next = nextDistinctNode;
			current = nextDistinctNode;
		}
	}

	private static void removeDups_sets() {
		LinkedList current = root;
		Set<Integer> setOfValues = new TreeSet<Integer>();
		while (current != null) {
			setOfValues.add(current.value);
			current = current.next;
		}
		root = null;
		for (Integer integer : setOfValues) {
			insert(integer);
		}
		System.out.println();
	}
	private static void insert(int data) {
		LinkedList current;
		if (root == null) {
			root = new LinkedList(data);
		} else {
			current = root;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new LinkedList(data);
		}
	}

	private static void printList() {
		LinkedList current = root;
		System.out.println("Linked List : ");
		System.out.print("Root -->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}

}
