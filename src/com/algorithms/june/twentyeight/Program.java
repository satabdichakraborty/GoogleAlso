package com.algorithms.june.twentyeight;

import java.util.*;

//Feel free to add new properties and methods to the class.
class Program {
	static class DoublyLinkedList {
		public Node head;
		public Node tail;

		public void setHead(Node node) {
			if (head == null) {
				head = node;
				tail = node;
			} else {
				insertBefore(head, node);
			}
		}

		public void setTail(Node node) {
			if (tail == null) {
				setHead(node);
				return;
			} else {
				insertAfter(tail, node);
			}
		}

		public void insertBefore(Node node, Node nodeToInsert) {
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

		public void insertAfter(Node node, Node nodeToInsert) {
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

		public void insertAtPosition(int position, Node nodeToInsert) {
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

		public void removeNodesWithValue(int value) {
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

		public void removeNodeWithBindings(Node node) {
			if (node.prev != null) {
				node.prev.next = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			}
			node.prev = null;
			node.next = null;
		}

		public void remove(Node node) {
			if (node == head) {
				head = head.next;
			} else if (node == tail) {
				tail = tail.prev;
			} else {
				removeNodeWithBindings(node);
			}
		}

		public boolean containsNodeWithValue(int value) {
			Node current = head;
			while (current != null && value != current.value) {
				current = current.next;
			}
			return current != null ? true : false;
		}

// Do not edit the class below.
		static class Node {
			public int value;
			public Node prev;
			public Node next;

			public Node(int value) {
				this.value = value;
			}
		}
	}
}
