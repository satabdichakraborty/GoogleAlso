package com.algorithms.june.eighteen;

class Program {

	public static void main(String[] args) {
		Node head = new Node(10);
		// DoublyLinkedList doubly =
	}

	static class DoublyLinkedList {
		public Node head;
		public Node tail;

		public void setHead(Node node) {
			if (head == null) {
				head = node;
			} else {
				head.next = node;
			}
			tail = node;
		}

		public void setTail(Node node) {

			if (tail == null) {
				head = node;
				tail = node;
			} else {
				Node previousToTail = tail;
				previousToTail.next = node;
				node.prev = previousToTail;
				tail = node;
			}
		}

		public void insertBefore(Node node, Node nodeToInsert) {
			if (node.prev == null) {
				setHead(nodeToInsert);
			} else if (node.next == null) {
				setTail(nodeToInsert);
			} else {
				Node previousNode = node.prev;
				previousNode.next = nodeToInsert;

				nodeToInsert.prev = previousNode;
				nodeToInsert.next = node;

				node.prev = nodeToInsert;
			}
		}

		public void insertAfter(Node node, Node nodeToInsert) {
			if (node.next == null) {
				setTail(nodeToInsert);
			} else if (node.prev == null) {
				setHead(nodeToInsert);
			} else {
				Node nextNode = node.next;
				node.next = nodeToInsert;
				nodeToInsert.prev = node;
				nodeToInsert.next = nextNode;
				nextNode.prev = nodeToInsert;
			}
		}

		public void insertAtPosition(int position, Node nodeToInsert) {
			Node current = head;
			int temp = 0;
			Node previousNode = null;
			while (temp < position && current != null) {
				temp++;
				previousNode = current;
				current = current.next;
			}

			if (previousNode == null) {
				setHead(nodeToInsert);
			} else if (current != null && current.next == null) {
				setTail(nodeToInsert);
			} else {
				previousNode.next = nodeToInsert;

				nodeToInsert.prev = previousNode;
				nodeToInsert.next = previousNode.next.next;
			}
		}

		public void removeNodesWithValue(int value) {
			if (containsNodeWithValue(value)) {
				Node current = head;
				Node previousNode = null;
				while (current != null && current.value != value) {
					previousNode = current;
					current = current.next;
				}
				if (previousNode == null) {
					head = head.next;
				} else if (current == tail) {
					previousNode.next = null;
					tail = previousNode;
				} else {
					previousNode.next = current.next;
				} 
			}
		}

		public void remove(Node node) {
			removeNodesWithValue(node.value);
		}

		public boolean containsNodeWithValue(int value) {

			Node current = head;
			while (current != null) {
				if (value == current.value) {
					return true;
				}
				current = current.next;
			}
			return false;
		}
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
