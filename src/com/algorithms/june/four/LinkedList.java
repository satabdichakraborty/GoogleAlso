package com.algorithms.june.four;

public class LinkedList {

	public int value;
	public LinkedList next;

	public LinkedList(int value) {
		this.value = value;
		this.next = null;
	}

	public LinkedList insert(LinkedList linkedList, int value) {
		LinkedList current = null;

		current = linkedList;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new LinkedList(value);

		return linkedList;
	}

	public void display(LinkedList linkedList) {
		LinkedList current = linkedList;
		System.out.print("head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

}
