package com.algorithms.tree.binarysearchtree.recursive;

public class BSTree {

	BSTreeNode root;

	public BSTree(int data) {
		this.root = root;
	}

	public void insert(int newNode) {
		if (root == null) {
			System.out.println("Creating root with data = [" + newNode + "]");
			root = new BSTreeNode(newNode);
		} else {
			root.insert(newNode);
		}
	}

	public BSTreeNode find(int value) {
		if (root != null) {
			if (root.getData() == value) {
				return root;
			} else {
				return root.find(value);
			}
		} else {
			return null;
		}
	}

	public void inOrderTraversal() {
		if (root != null) {
			root.inOrderTraversal();
		} else {
			System.out.println("This is an empty tree");
		}
	}

	public void preOrderTraversal() {
		if (root != null) {
			root.preOrderTraversal();
		} else {
			System.out.println("This is an empty tree");
		}
	}

	public void postOrderTraversal() {
		if (root != null) {
			root.postOrderTraversal();
		} else {
			System.out.println("This is an empty tree");
		}
	}

	public int getMin() {
		if (root != null) {
			return root.getMin();
		} else {
			System.out.println("This is an empty tree");
			return -1;
		}

	}

	public int getMax() {
		if (root != null) {
			return root.getMax();
		} else {
			System.out.println("This is an empty tree");
			return -1;
		}

	}

	public void deleteNode(int value) {
		root = delete(root, value);
	}

	private BSTreeNode delete(BSTreeNode subTreeRoot, int value) {

		if (subTreeRoot == null) {
			return subTreeRoot;
		}

		if (value < subTreeRoot.getData()) {
			subTreeRoot.setLeftNode(delete(subTreeRoot.getLeftNode(), value));

		} else if (value > subTreeRoot.getData()) {
			subTreeRoot.setRightNode(delete(subTreeRoot.getRightNode(), value));
		} else {

			// Case 1 & 2 if the deletion node has only one child
			if (subTreeRoot.getLeftNode() == null) {
				return subTreeRoot.getRightNode();
			} else if (subTreeRoot.getRightNode() == null) {
				return subTreeRoot.getLeftNode();
			} else {
				// Case 3 if the node to be deleted have both left and right children
				subTreeRoot.setData(subTreeRoot.getRightNode().getMin());
				subTreeRoot.setRightNode(delete(subTreeRoot.getRightNode(), subTreeRoot.getData()));
			}
		}
		System.out.println("subTreeRoot data = " + subTreeRoot.getData());
		return subTreeRoot;

	}

	private boolean validateBSTNodes(BSTreeNode subRoot, int minValue, int maxValue) {
		System.out
				.println("subRoot = " + subRoot.getData() + " : minValue = " + minValue + " : maxValue = " + maxValue);
		if (subRoot.getData() < minValue || subRoot.getData() >= maxValue) {
			return false;
		}

		if (subRoot.leftNode != null && !validateBSTNodes(subRoot.leftNode, minValue, subRoot.getData())) {
			return false;
		}

		if (subRoot.rightNode != null && !validateBSTNodes(subRoot.rightNode, subRoot.getData(), maxValue)) {
			return false;
		}

		return true;
	}

	public boolean validateBST() {

		return validateBSTNodes(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}
