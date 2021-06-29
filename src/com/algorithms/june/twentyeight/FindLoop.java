package com.algorithms.june.twentyeight;

public class FindLoop {

	private static LinkedList head;

	public static void main(String[] args) {
		createLoopedLinkedList();
		// print();
		int loopNode = findLoop();
		System.out.println("Loop node is " + loopNode);
	}

	private static int findLoop() {
		LinkedList p1 = head.next;
		LinkedList p2 = head.next.next;
		while (p1 != p2) {
			//System.out.println("1st While : p1 = [" + p1.value + "] : p2 = [" + p2.value + "]");
			p1 = p1.next;
			p2 = p2.next.next;
		}
		//System.out.println("Out of 1st While : p1 = [" + p1.value + "] : p2 = [" + p2.value + "]");
		p1 = head;
		while (p1 != p2) {
			//System.out.println("2nd While : p1 = [" + p1.value + "] : p2 = [" + p2.value + "]");
			p1 = p1.next;
			p2 = p2.next.next;
		}
		//System.out.println("Out of 2nd While : p1 = [" + p1.value + "] : p2 = [" + p2.value + "]");
		return p1.value;
	}

	private static void print() {
		LinkedList current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");
	}

	private static void createLoopedLinkedList() {
		LinkedList node3 = null;
		LinkedList current = null;
		for (int i = 0; i < 9; i++) {
			if (head == null) {
				head = new LinkedList(i);
			} else {
				current = head;
				while (current.next != null) {
					if (3 == current.value) {
						node3 = current;
					}
					current = current.next;
				}
				current.next = new LinkedList(i);
			}
		}
		current.next = node3;
	}

}
