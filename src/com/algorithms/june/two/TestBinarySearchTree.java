package com.algorithms.june.two;

class TreeNode {

	int data;
	TreeNode leftChild;
	TreeNode rightChild;

	public TreeNode(int data) {
		this.data = data;
	}

	public void insert(int value) {
		if (value < this.data && this.leftChild != null) {
			leftChild.insert(value);
		} else if (value < this.data && this.leftChild == null) {
			leftChild = new TreeNode(value);
		} else if (value > this.data && rightChild != null) {
			rightChild.insert(value);
		} else {
			rightChild = new TreeNode(value);
		}
	}

	public void displayTreeInOrder() {

		if (this.leftChild != null) {
			leftChild.displayTreeInOrder();
		}

		System.out.print(this.data + " ");

		if (this.rightChild != null) {
			rightChild.displayTreeInOrder();
		}
	}

	public int getMin() {

		if (this.leftChild != null) {
			return leftChild.getMin();
		} else {
			return this.data;
		}
	}

	public int getMax() {

		if (this.rightChild != null) {
			return rightChild.getMax();
		} else {
			return this.data;
		}
	}

}// End of TreeNode Class

public class TestBinarySearchTree {
	private static TreeNode root;

	public static void main(String[] args) {
		insert(10);
		insert(5);
		insert(11);
		insert(2);
		insert(15);
		insert(13);
		insert(22);
		insert(1);
		insert(14);
		displayTreeInOrder();
		System.out.println();

		System.out.println("Min Tree Value = " + getMin());
		System.out.println("Max Tree Value = " + getMax());
		/*
		 * System.out.println(); System.out.println("trying to delete --  15");
		 * delete(15); System.out.println("Tree after deleting 15, if present");
		 * displayTreeInOrder(); System.out.println();
		 */
		System.out.println();
		System.out.println("trying to delete --  8888");
		delete(8888);
		System.out.println("Tree after deleting 8888, if present");
		displayTreeInOrder();
		System.out.println();

		/*
		 * // No children scenario System.out.println("trying to delete -- 1");
		 * System.out.println(); System.out.println("trying to delete --  1");
		 * delete(1); System.out.println("Tree after deleting 1, if present");
		 * displayTreeInOrder(); System.out.println();
		 * 
		 * // only right children scenario System.out.println();
		 * System.out.println("trying to delete --  11"); delete(11);
		 * System.out.println("Tree after deleting 11, if present");
		 * displayTreeInOrder(); System.out.println();
		 */

	}

	public static void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}

	public static void delete(int value) {
		root = deleteInTree(root, value);

	}

	private static TreeNode deleteInTree(TreeNode subTreeRoot, int value) {
		if (subTreeRoot == null) {
			return subTreeRoot;
		}

		if (value < subTreeRoot.data) {
			// System.out.println("If block subTreeRoot.data = " + subTreeRoot.data);
			subTreeRoot.leftChild = deleteInTree(subTreeRoot.leftChild, value);
		} else if (value > subTreeRoot.data) {
			// System.out.println("Else IF block subTreeRoot.data = " + subTreeRoot.data);
			subTreeRoot.rightChild = deleteInTree(subTreeRoot.rightChild, value);
		} else {
			// System.out.println("Else block subTreeRoot.data = " + subTreeRoot.data);
			if (subTreeRoot.leftChild == null) {
				return subTreeRoot.rightChild;
			} else if (subTreeRoot.rightChild == null) {
				return subTreeRoot.leftChild;
			} else {
				subTreeRoot.data = subTreeRoot.rightChild.getMin();
				subTreeRoot.rightChild = deleteInTree(subTreeRoot.rightChild, subTreeRoot.data);
			}
		}

		return subTreeRoot;
	}

	public static void displayTreeInOrder() {
		if (root == null) {
			System.err.println("Tree is empty");
		} else {
			root.displayTreeInOrder();
		}
	}

	public static int getMin() {
		if (root == null) {
			System.err.println("Tree is empty");
			return Integer.MIN_VALUE;
		} else {
			return root.getMin();
		}
	}

	public static int getMax() {
		if (root == null) {
			System.err.println("Tree is empty");
			return Integer.MAX_VALUE;
		} else {
			return root.getMax();
		}
	}

}
