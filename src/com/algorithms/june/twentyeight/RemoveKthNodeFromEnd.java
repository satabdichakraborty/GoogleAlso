package com.algorithms.june.twentyeight;

public class RemoveKthNodeFromEnd {

	private static LinkedList head = null;

	public static void main(String[] args) {
		createLinkedList();
		System.out.println("Print LinkedList before removal");
		print();
		int k = 4;
		System.out.println("Going to remove k=[" + k + "] node from end.");
		removekthNodeFromEnd(k);
		System.out.println("Print LinkedList after removal");
		print();
	}

	private static void removekthNodeFromEnd(int k) {
		LinkedList p1 = head;
		LinkedList p2 = head;
		LinkedList prev = null;
		for (int i = 1; i < k; i++) {
			p1 = p1.next;
		}
		while (p1.next != null) {
			prev = p2;
			p1 = p1.next;
			p2 = p2.next;
		}
		prev.next = p2.next;
	}

	private static void print() {
		LinkedList current = head;
		System.out.print("head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");
		// Inserting a blank line at the end
		System.out.println();
	}

	private static void createLinkedList() {
		for (int i = 0; i < 11; i++) {
			if (head == null) {
				head = new LinkedList(i);
			} else {
				LinkedList current = head;
				while (current.next != null) {
					current = current.next;
				}
				current.next = new LinkedList(i);
			}
		}

	}

}
