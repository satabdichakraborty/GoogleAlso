package com.algorithms.june.seventeen;

public class Node {
	int data;
	Node next;
	int size;

	Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

	public Node insert(Node head, int target) {
		Node current = head;
		while (current != null && current.next != null) {
			current = current.next;
		}
		if (current == null) {
			current = new Node(target);
		} else {
			current.next = new Node(target);
		}
		size++;
		return head;
	}

	public void traverseNodes(Node head) {
		Node current = head;
		System.out.println();
		System.out.print("head-->");
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print("null");

	}

	public Node delete(Node head, int target) {
		Node current = head;
		Node previous = null;
		while (current != null && current.next != null && current.data != target) {
			previous = current;
			current = current.next;
		}

		if (previous == null) {
			head = head.next;
			size--;
		} else {
			previous.next = current.next;
			size--;
		}
		return head;
	}

}
