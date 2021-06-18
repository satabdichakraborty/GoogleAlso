package com.algorithms.june.eleven;

class BST {

	int data;
	BST left;
	BST right;

	public BST(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BST [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	public BST insert(int value) {
		BST current = this;
		while (current != null) {
			if (value < current.data) {
				if (current.left != null) {
					current = current.left;
				} else {
					current.left = new BST(value);
					break;
				}
			} else {
				if (current.right != null) {
					current = current.right;
				} else {
					current.right = new BST(value);
					break;
				}
			}
		}
		return this;
	}

	public void displayInOrder() {

		if (left != null) {
			left.displayInOrder();
		}

		System.out.print(data + " ");

		if (right != null) {
			right.displayInOrder();
		}
	}

	public BST delete(int target) {
		remove(target, null);
		return this;
	}

	public int getMin() {
		if (this.left != null) {
			return left.getMin();
		} else {
			return this.data;
		}
	}

	private void remove(int target, BST parent) {
		BST current = this;
		while (current != null) {
			if (target < current.data) {
				parent = current;
				current = current.left;
			} else if (target > current.data) {
				parent = current;
				current = current.right;
			} else {
				if (current.left != null && current.right != null) {

					current.data = current.right.getMin();
					current.right.remove(current.data, current);

				} else if (parent == null) {
					if (current.left != null) {
						current.data = current.left.data;
						current.left = current.left.left;
						current.right = current.right.left;

					} else if (current.right != null) {
						current.data = current.right.data;
						current.left = current.right.left;
						current.right = current.right.right;

					} else {
						// This is a single node (only root) tree
						System.out.println(
								"You are here since you are trying to delete the only node in the tree [" + data + "]");
					}

				} else if (parent.left == current) {

					parent.left = current.left != null ? current.left : current.right;

				} else if (parent.right == current) {

					parent.right = current.left != null ? current.left : current.right;
				}
				break;

			}

		}

	}
}

public class TestBST {

	private static BST root;

	public static void main(String[] args) {

		testInsert();
		testDisplayInOrder();
		testMin();
		testDelete();

	}

	private static void testMin() {
		System.out.println("\nMinimum value from tree = " + root.getMin());
	}

	public static void testInsert() {

		root = new BST(10);

		root.insert(5);
		root.insert(15);
		root.insert(2);
		root.insert(7);
		root.insert(1);
		root.insert(11);
		root.insert(17);
		root.insert(22);

	}

	private static void testDisplayInOrder() {
		root.displayInOrder();

	}

	private static void testDelete() {
		root.delete(1);
		System.out.println();
		System.out.println("Tree after deleting 1 ");
		testDisplayInOrder();

		root.delete(22);
		System.out.println();
		System.out.println("Tree after deleting 22 ");
		testDisplayInOrder();

		root.delete(5);
		System.out.println();
		System.out.println("Tree after deleting 5 ");
		testDisplayInOrder();

		root.delete(15);
		System.out.println();
		System.out.println("Tree after deleting 15 ");
		testDisplayInOrder();

		root.delete(10);
		System.out.println();
		System.out.println("Tree after deleting root 10 ");
		testDisplayInOrder();

		root.delete(17);
		System.out.println();
		System.out.println("Tree after deleting root 7 ");
		testDisplayInOrder();

		root.delete(7);
		System.out.println();
		System.out.println("Tree after deleting root 7 ");
		testDisplayInOrder();

		root.delete(2);
		System.out.println();
		System.out.println("Tree after deleting root 2 ");
		testDisplayInOrder();

		root.delete(11);
		System.out.println();
		System.out.println("Tree after deleting root 11 ");
		testDisplayInOrder();

	}

}
