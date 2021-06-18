package com.algorithms.june.three;

class TreeNode {

	int data;
	TreeNode leftChild;
	TreeNode rightChild;

	public TreeNode(int data) {
		this.data = data;
	}

	public void insert(int value) {
		if (value < this.data) {
			if (leftChild != null) {
				leftChild.insert(value);
			} else {
				leftChild = new TreeNode(value);
			}
		} else {
			if (rightChild != null) {
				rightChild.insert(value);
			} else {
				rightChild = new TreeNode(value);
			}
		}
	}

	public void printTreeNodesInOrder() {
		if (leftChild != null) {
			leftChild.printTreeNodesInOrder();
		}
		System.out.print(this.data + " ");

		if (rightChild != null) {
			rightChild.printTreeNodesInOrder();
		}
	}

	public int getMin() {
		if (leftChild != null) {
			return leftChild.getMin();
		} else {
			return this.data;
		}
	}

	public int getMax() {
		if (rightChild != null) {
			return rightChild.getMax();
		} else {
			return this.data;
		}
	}
}

public class BinrarySearchTree {

	private static TreeNode root;

	public static void main(String[] args) {

		root = new TreeNode(10);

		root.insert(5);
		root.insert(6);
		root.insert(15);
		root.insert(22);
		root.insert(25);
		root.insert(1);
		root.insert(13);
		root.insert(14);
		root.insert(11);

		System.out.println("Printing tree inorder -->");
		root.printTreeNodesInOrder();

		System.out.println();
		System.out.println("\nGet Min Value - " + getMin());

		System.out.println();
		System.out.println("\nGet Max Value - " + getMax());

		System.out.println("Here comes delete --");
		System.out.println("Printing tree inorder before deleting 1-->");
		root.printTreeNodesInOrder();
		delete(1);
		System.out.println("\nPrinting tree inorder after deleting 1-->");
		root.printTreeNodesInOrder();

		System.out.println("Here comes delete --");
		System.out.println("Printing tree inorder before deleting 25-->");
		root.printTreeNodesInOrder();
		delete(25);
		System.out.println("\nPrinting tree inorder after deleting 25-->");
		root.printTreeNodesInOrder();

		System.out.println("Here comes delete --");
		System.out.println("Printing tree inorder before deleting 13-->");
		root.printTreeNodesInOrder();
		delete(13);
		System.out.println("\nPrinting tree inorder after deleting 13-->");
		root.printTreeNodesInOrder();

	}

	private static TreeNode delete(TreeNode subTreeRoot, int value) {
		if (subTreeRoot == null) {
			return subTreeRoot;
		}

		if (value < subTreeRoot.data && subTreeRoot.leftChild != null) {
			subTreeRoot.leftChild = delete(subTreeRoot.leftChild, value);
		} else if (value > subTreeRoot.data && subTreeRoot.rightChild != null) {
			subTreeRoot.rightChild = delete(subTreeRoot.rightChild, value);
		} else {
			// Here actual delete happens
			// Case 1 & 2 if treenode dont have either left or right child(ren)
			if (subTreeRoot.leftChild == null) {
				return subTreeRoot.rightChild;
			} else if (subTreeRoot.rightChild == null) {
				return subTreeRoot.leftChild;
			} else {
				// Case 3 if tree have both left & right children
				subTreeRoot.data = subTreeRoot.rightChild.getMin();
				subTreeRoot.rightChild = delete(subTreeRoot.rightChild, subTreeRoot.data);
			}
		}

		return subTreeRoot;
	}

	private static void delete(int value) {
		root = delete(root, value);
	}

	private static void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}

	private static void printTreeNodesInOrder() {
		if (root == null) {
			System.out.println("Empty Tree");
		} else {
			root.printTreeNodesInOrder();
		}
	}

	private static int getMin() {
		if (root == null) {
			System.out.println("Empty Tree");
			return Integer.MIN_VALUE;
		} else {
			return root.getMin();
		}
	}

	private static int getMax() {
		if (root == null) {
			System.out.println("Empty Tree");
			return Integer.MAX_VALUE;
		} else {
			return root.getMax();
		}
	}
}
