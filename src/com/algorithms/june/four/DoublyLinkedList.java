package com.algorithms.june.four;

class Node {

	int value;
	Node prev;
	Node next;

	Node(int value) {
		this.value = value;
	}

	public String toString() {
		return "Node [value=" + value + ", previous=" + prev + ", next=" + next + "]";
	}
}

public class DoublyLinkedList {

	private static Node head;
	private static Node tail;

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node3_2 = new Node(3);
		Node node3_3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		setHead(node1);
		setTail(node2);
		setTail(node3);
		setTail(node4);
		setTail(node5);
		setTail(node6);
		setHead(node4);

		System.out.println("Checking if node5 is present = " + containsNodeWithValue(node5));

		printNodes();
		System.out.println("\nBefore -- Trying to move existing node 3 just before node 6");
		insertBefore(node3, node6);
		System.out.println("After -- Trying to move existing node 3 just before node 6");
		printNodes();

		System.out.println("\nBefore -- Trying to add new node 3 after node 6");
		insertAfter(node3_2, node6);
		System.out.println("After -- Trying to add new node 3 after node 6");
		printNodes();

		System.out.println("\nBefore -- Trying to add new node 3 at position 1");
		insertAtPosition(1, node3_3);
		System.out.println("After -- Trying to add new node 3 at position 1");
		printNodes();

		System.out.println("\nBefore -- Trying to delete all nodes with value 3");
		removeNodesWithValue(3);
		System.out.println("After -- Trying to delete all nodes with value 3");
		printNodes();

		System.out.println("\nBefore -- Trying to delete all nodes with value 2");
		removeNodesWithValue(2);
		System.out.println("After -- Trying to delete all nodes with value 2");
		printNodes();

	}

	private static boolean containsNodeWithValue(Node node) {
		Node current = head;
		boolean isPresent = false;
		while (current != null && !isPresent) {
			if (current == node) {
				isPresent = true;
			} else {
				current = current.next;
			}
		}
		return isPresent;
	}

	private static void insertAtPosition(int position, Node nodeToInsert) {
		int count = 1;
		Node current = head;
		Node previousNode = null;

		while (current != null && count < position) {
			previousNode = current;
			current = current.next;
			count++;
		}
		if (previousNode != null) {
			previousNode.next = nodeToInsert;
			nodeToInsert.prev = previousNode;
			nodeToInsert.next = current;
		} else {
			setHead(nodeToInsert);
		}

	}

	// Check if the newnode to be inserted before node is already present
	// if yes, move the node to before node
	// if no, then insert the newNode before node
	private static void insertBefore(Node nodeToInsert, Node node) {
		Node current = head;
		Node previousNode = null;

		if (containsNodeWithValue(nodeToInsert)) {
			remove(nodeToInsert);
		}

		while (current != null && current.value != node.value) {
			previousNode = current;
			current = current.next;
		}
		if (previousNode != null) {
			previousNode.next = nodeToInsert;
			nodeToInsert.prev = previousNode;
			nodeToInsert.next = current;
		} else {
			setHead(nodeToInsert);
		}
	}

	private static void insertAfter(Node nodeToInsert, Node node) {
		Node current = head;
		Node nextNode = null;

		if (containsNodeWithValue(nodeToInsert)) {
			remove(nodeToInsert);
		}

		while (current != null && current.value != node.value) {
			current = current.next;
		}
		nextNode = current.next;
		current.next = nodeToInsert;

		nodeToInsert.prev = current;
		nodeToInsert.next = nextNode;
	}

	private static void printNodes() {
		Node current = head;
		System.out.print("head -->");
		while (current != null) {
			System.out.print(current.value + "<-->");
			current = current.next;
		}
		System.out.print("null");
	}

	// If the received node is already present in the linked list then move that to
	// head or else insert the new node to head of the list
	private static void setHead(Node node) {
		if (head == null) {// if list is empty then insert newNode at head
			head = node;
			tail = head;
			return;
		}
		insertBefore(head, node);

	}

	private static void remove(Node node) {
		System.out.println("Deleting " + node.value);
		Node current = null;
		Node previous = null;
		if (head == null) {
			System.out.println("Empty list nothing to delete");
			return;
		} else {
			current = head;
			while (current != null) {
				if (current == node) {
					// delete node
					if (previous == null) {
						head = head.next;
						current = null;
					} else {
						previous.next = current.next;
						current = null;
					}
				} else {
					previous = current;
					current = current.next;
				}
			}
		}

	}

	private static void removeNodesWithValue(int value) {
		System.out.println("Deleting " + value);
		Node current = null;
		Node previous = null;
		if (head == null) {
			System.out.println("Empty list nothing to delete");
			return;
		} else {
			current = head;
			while (current != null) {
				if (current.value == value) {
					// delete node
					if (previous == null) {
						head = head.next;
						// current = null;
					} else {
						previous.next = current.next;
						// current = null;
					}
					current = current.next;
				} else {
					previous = current;
					current = current.next;
				}
			}
		}

	}

	private static void setTail(Node node) {
		if (tail == null) {
			setHead(node);
			return;
		}
		insertAfter(tail, node);

	}

}
