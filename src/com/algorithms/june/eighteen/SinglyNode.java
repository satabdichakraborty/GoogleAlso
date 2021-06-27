package com.algorithms.june.eighteen;

public class SinglyNode {

	int data;
	SinglyNode next;

	SinglyNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SinglyNode [data=" + data + ", next=" + next + "]";
	}

	public void insert(int target, SinglyNode head) {
		SinglyNode current = head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = new SinglyNode(target);

	}

	public SinglyNode delete(int target, SinglyNode head) {
		SinglyNode current = head;
		SinglyNode previous = null;
		while (current != null && current.data != target) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			head = head.next;
		} else {
			previous.next = current.next;
		}
		return head;
	}

}
