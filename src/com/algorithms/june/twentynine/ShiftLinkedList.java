package com.algorithms.june.twentynine;

public class ShiftLinkedList {

	private static LinkedList head;

	public static void main(String[] args) {
		createLinkedList();
		System.out.println("Before shift");
		print(head);
		head = shiftLinkedList(head, 2);
		System.out.println("\nAfter shift");
		print(head);
	}

	public static LinkedList shiftLinkedList(LinkedList head, int k) {// Get the size of the linked list & pointer to
																		// tail
		LinkedList current = head;
		int size = 0;
		LinkedList tail = null;
		LinkedList newtail = head;
		while (current != null) {
			tail = current;
			current = current.next;
			size++;
		}
		System.out.println("\nSize = "+size);
		int offset = Math.abs(k) % size;
		if (offset == 0)
			return head;
		int newTailPos = (k > 0) ? (size - offset) : offset;
		System.out.println("Offset = "+offset);
		// get the new tail pointer
		for (int i = 1; i < newTailPos; i++) {
			newtail = newtail.next;
		}

		// Shifting the linked list
		tail.next = head;
		head = newtail.next;
		newtail.next = null;

		return head;
	}

	public static void createLinkedList() {
		for (int i = 0; i < 6; i++) {
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

	public static void print(LinkedList head) {
		LinkedList current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

}
