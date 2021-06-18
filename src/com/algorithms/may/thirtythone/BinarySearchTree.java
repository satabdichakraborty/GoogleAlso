package com.algorithms.may.thirtythone;

class BSTNode {
	int data;
	BSTNode leftChild;
	BSTNode rightChild;

	public BSTNode(int data) {
		this.data = data;
	}

	public void insert(int data) {
		if (data < this.data) {
			if (this.leftChild == null) {
				this.leftChild = new BSTNode(data);
			} else {
				leftChild.insert(data);
			}
		} else {
			if (this.rightChild == null) {
				this.rightChild = new BSTNode(data);
			} else {
				rightChild.insert(data);
			}
		}
	}

	public void printInOrder() {

		if (this.leftChild != null) {
			leftChild.printInOrder();
		}
		System.out.print(this.data + " ");

		if (this.rightChild != null) {
			rightChild.printInOrder();
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
			return rightChild.getMin();
		} else {
			return this.data;
		}
	}

	public boolean search(int value) {
		if (value < this.data) {
			if (leftChild != null) {
				return leftChild.search(value);
			} else {
				return false;
			}
		} else if (value > this.data) {
			if (rightChild != null) {
				return rightChild.search(value);
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public int findClosestValue(int target) {
		return findClosestValue(target, this.data);
	}

	/*
	 * Call this method with tree node value and target value if target value is less
	 * than the node go and search in left tree if target value is greater than the
	 * node go and search in left tree If target value is less that node but there
	 * is no left node or, target value is greater than the node but there is no
	 * right node then compare the node value with parent node value and return the
	 * one closest to the target value
	 */
	public int findClosestValue(int target, int closestVal) {
		if (Math.abs(target - closestVal) > Math.abs(target - this.data)) {
			closestVal = this.data;
		}

		if (target < this.data && this.leftChild != null) {
			return leftChild.findClosestValue(target, this.data);
		} else if (target > this.data && this.rightChild != null) {
			return rightChild.findClosestValue(target, this.data);
		} else {
			return closestVal;
		}

	}
}

class BSTree {
	private BSTNode root;

	public BSTree(int data) {
		this.root = new BSTNode(data);
	}

	public int getTreeMin() {
		if (root != null) {
			return root.getMin();
		} else {
			System.err.println("Tree is empty");
			return -1;
		}
	}

	public int getTreeMax() {
		if (root != null) {
			return root.getMax();
		} else {
			System.err.println("Tree is empty");
			return -1;
		}
	}

	public void insertTree(int data) {
		if (root == null) {
			root = new BSTNode(data);
		} else {
			root.insert(data);
		}
	}

	public void printTree() {

		if (root == null) {
			System.err.println("Empty tree nothing to print");
		} else {
			root.printInOrder();
		}
	}

	public boolean search(int value) {

		if (root == null) {
			System.err.println("Empty tree nothing to print");
			return false;
		} else {
			if (root.data == value) {
				return true;
			} else {
				return root.search(value);
			}
		}
	}

	public int findClosestValue(int value) {

		if (root == null) {
			System.err.println("Empty tree nothing to print");
			return -1;
		} else {
			return root.findClosestValue(value);

		}
	}

}

public class BinarySearchTree {

	private static BSTree tree;

	public static void main(String[] args) {

		tree = new BSTree(10);

		tree.insertTree(5);
		tree.insertTree(15);
		tree.insertTree(2);
		tree.insertTree(13);
		tree.insertTree(22);
		tree.insertTree(14);
		tree.insertTree(1);

		System.out.println("Print all tree nodes inOrder");
		tree.printTree();
		System.out.println();
		System.out.println("Min value = " + tree.getTreeMin());

		System.out.println();
		System.out.println("Max value = " + tree.getTreeMax());

		System.out.println("Looking for value 7.. found? " + tree.search(7));
		System.out.println("Looking for value 25.. found? " + tree.search(25));

		System.out.println("Value closest to 12 is [" + tree.findClosestValue(12) + "]");

	}

}
