package com.algorithms.june.twentyeight;

public class DoublyLinkedList {

	public static Node head;
	public static Node tail;

	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		System.out.println("Inserting 5 at head");
		setHead(five);
		print();

		System.out.println("Inserting 3 at head");
		setHead(three);
		print();

		System.out.println("Inserting 2 at head");
		setHead(two);
		print();

		System.out.println("Inserting 1 at head");
		setHead(one);
		print();

		System.out.println("Inserting 4 before 5");
		insertBefore(five, four);
		print();

		System.out.println("Inserting 6 after 5");
		insertAfter(five, six);
		print();
		
		System.out.println("Inserting at position 7");
		insertAtPosition(7, seven);
		print();

		/*
		 * System.out.println("Does this list contains 2 ? " +
		 * containsNodeWithValue(2)); System.out.println("Does this list contains 8 ? "
		 * + containsNodeWithValue(8));
		 * 
		 * System.out.println("Removing node with value 2"); removeNodesWithValue(2);
		 * print();
		 * 
		 * System.out.println("Removing head node with value 1");
		 * removeNodesWithValue(1); print();
		 * 
		 * System.out.println("Removing node with value" + three.value); remove(three);
		 * print();
		 * 
		 * System.out.println("Removing node with value " + four.value); remove(four);
		 * print();
		 */

	}

	public static void setHead(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			insertBefore(head, node);
		}
	}

	public static void setTail(Node node) {
		if (tail == null) {
			setHead(node);
			return;
		} else {
			insertAfter(tail, node);
		}
	}

	public static void insertBefore(Node node, Node nodeToInsert) {
		if (nodeToInsert == head || nodeToInsert == tail)
			return;
		remove(nodeToInsert);

		nodeToInsert.prev = node.prev;
		nodeToInsert.next = node;
		if (nodeToInsert.prev == null) {
			head = nodeToInsert;
		} else {
			node.prev.next = nodeToInsert;
		}
		node.prev = nodeToInsert;
	}

	public static void insertAfter(Node node, Node nodeToInsert) {
		if (nodeToInsert == head || nodeToInsert == tail)
			return;
		remove(nodeToInsert);

		nodeToInsert.prev = node;
		nodeToInsert.next = node.next;

		if (nodeToInsert.next == null) {
			tail = nodeToInsert;
		} else {
			node.next.prev = nodeToInsert;
		}
		node.next = nodeToInsert;
	}

	public static void insertAtPosition(int position, Node nodeToInsert) {
		if (1 == position) {
			setHead(nodeToInsert);
			return;
		}
		Node current = head;
		int temp = 1;
		while (current != null && temp++ < position) {
			current = current.next;
		}
		if (current == null) {
			setTail(nodeToInsert);
		} else {
			insertAfter(current, nodeToInsert);
		}

	}

	public static void removeNodesWithValue(int value) {
		Node current = head;
		Node nodeToRemove = null;
		while (current != null) {
			nodeToRemove = current;
			current = current.next;
			if (nodeToRemove.value == value) {
				remove(nodeToRemove);
			}
		}
	}

	private static void removeNodeWithBindings(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		node.prev = null;
		node.next = null;
	}

	public static void remove(Node node) {

		if (node == head) {
			head = head.next;
		} else if (node == tail) {
			tail = tail.prev;
		} else {
			removeNodeWithBindings(node);
		}

	}

	public static boolean containsNodeWithValue(int value) {
		Node current = head;
		while (current != null && value != current.value) {
			current = current.next;
		}
		return current != null ? true : false;
	}

	public static void print() {
		Node current = head;
		System.out.print("Head<-->");
		while (current != null) {
			System.out.print(current.value + "<-->");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}

}
