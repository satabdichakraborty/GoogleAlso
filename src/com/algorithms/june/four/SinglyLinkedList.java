package com.algorithms.june.four;

public class SinglyLinkedList {

	private static LinkedList head;

	public static void main(String[] args) {
		insert(0);
		insert(1);
		insert(2);
		insert(3);
		insert(4);
		insert(5);
		insert(6);
		insert(7);
		insert(8);
		insert(9);

		System.out.println("Print List--");
		printList();
		removeKthNodeFromEnd(head, 10);
		System.out.println();
		printList();

	}

	public static void removeKthNodeFromEnd(LinkedList head, int k) {

		LinkedList kthNode = head;
		LinkedList current = head;
		int count = 1;
		while (current != null && count <= k) {
			current = current.next;
			count++;
		}
		// If we have already reached the end of the LinkedList
		// then adjust head
		if (current == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		// Otherwise move both the pointers at Kth interval until we reach the end of
		// the list
		while (current.next != null) {
			current = current.next;
			kthNode = kthNode.next;
			count++;
		}
		kthNode.next = kthNode.next.next;
	}

	private static void insert(int value) {
		LinkedList current = null;
		if (head == null) {
			head = new LinkedList(value);
		} else {
			current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new LinkedList(value);
		}
	}

	private static void printList() {
		LinkedList current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

}
