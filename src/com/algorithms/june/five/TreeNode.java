package com.algorithms.june.five;

public class TreeNode {

	int value;
	TreeNode left;
	TreeNode right;

	TreeNode(int value) {
		this.value = value;
	}

	public void insert(int value) {
		if (value < this.value) {
			if (left != null) {
				left.insert(value);
			} else {
				left = new TreeNode(value);
			}
		} else {
			if (right != null) {
				right.insert(value);
			} else {
				right = new TreeNode(value);
			}
		}
	}

	public boolean search(int value) {
		if (value < this.value) {
			if (left == null) {
				return false;
			} else {
				return left.search(value);
			}
		} else if (value > this.value) {
			if (right == null) {
				return false;
			} else {
				return right.search(value);
			}
		} else {
			return true;
		}
	}

	public void printInOrder() {
		if (this.left != null) {
			left.printInOrder();
		}

		System.out.print(this.value + " ");

		if (this.right != null) {
			right.printInOrder();
		}
	}

}
