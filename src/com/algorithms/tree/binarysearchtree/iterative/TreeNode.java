package com.algorithms.tree.binarysearchtree.iterative;

public class TreeNode {

	int value;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
		this.value = data;
	}

	public TreeNode delete(int value) {
		delete(null, value);
		return this;
	}

	private boolean validateBST(TreeNode tree, int minValue, int maxValue) {
		if (tree.value < minValue || tree.value >= maxValue) {
			return false;
		}

		if (tree.left != null && !validateBST(tree.left, minValue, tree.value)) {
			return false;
		}

		if (tree.right != null && !validateBST(tree.right, tree.value, maxValue)) {
			return false;
		}
		return true;
	}

	public boolean validateBST(TreeNode tree) {
		return validateBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// Average: O(Log(n)) time | O(1) space
	// Worst: O(n) time | O(1) space
	public int findClosestValueInBst(TreeNode tree, int target) {
		TreeNode currentNode = tree;
		int closestValueInBst = Integer.MAX_VALUE;

		while (currentNode != null) {
			if ((int) Math.abs(target - closestValueInBst) > (int) Math.abs(target - currentNode.value)) {
				closestValueInBst = currentNode.value;
			}
			// System.out.println("closestNodeVal = " + closestNodeVal);
			if (target < currentNode.value) {
				currentNode = currentNode.left;
			} else if (target > currentNode.value) {
				currentNode = currentNode.right;
			} else {
				break;
			}
		}
		return closestValueInBst;
	}

	// Average: O(Log(n)) time | O(1) space
	// Worst: O(n) time | O(1) space
	public void delete(TreeNode parentNode, int value) {
		TreeNode currentNode = this;

		while (currentNode != null) {
			if (value < currentNode.value) {
				if (currentNode.left != null) {
					parentNode = currentNode;
					currentNode = currentNode.left;
				}
			} else if (value > currentNode.value) {
				if (currentNode.right != null) {
					parentNode = currentNode;
					currentNode = currentNode.right;
				}
			} else {
				if (currentNode.left != null && currentNode.right != null) {
					currentNode.value = currentNode.right.getMin();
					currentNode.right.delete(parentNode, currentNode.value);
				} else if (parentNode == null) {
					// deleting tree root scnario
					if (currentNode.left != null) {
						currentNode.value = currentNode.left.value;
						currentNode.right = currentNode.left.right;
						currentNode.left = currentNode.left.left;
					} else if (currentNode.right != null) {
						currentNode.value = currentNode.right.value;
						currentNode.left = currentNode.right.left;
						currentNode.right = currentNode.right.right;
					} else {
						// This is a single node tree and we are deleting the root node.. do nothing..
					}

				} else if (parentNode.left == currentNode) {
					// deleting right child of a node with only right child but the node to be
					// deleted is not leaf node
					parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
				} else if (parentNode.right == currentNode) {
					// deleting left child of a node with only left child but the node to be deleted
					// is not leaf node
					parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
				}
				break;
			}
		}
		// return this; // This is just for chaining not required for algorithm
	}

	public TreeNode insert(int value) {
		TreeNode currentRoot = this;

		while (currentRoot != null) {
			if (value < currentRoot.value) {
				if (currentRoot.left == null) {
					currentRoot.left = new TreeNode(value);
					break;
				} else {
					currentRoot = currentRoot.left;
				}
			} else {
				if (currentRoot.right == null) {
					currentRoot.right = new TreeNode(value);
					break;
				} else {
					currentRoot = currentRoot.right;
				}
			}
		}
		return this;
	}

	public boolean search(int value) {
		TreeNode currentRoot = this;

		while (currentRoot != null) {
			// System.out.println("currentRoot = " + currentRoot.data + " : Search value = "
			// + value);
			if (value < currentRoot.value) {
				if (currentRoot.left != null) {
					currentRoot = currentRoot.left;
				} else {
					return false;
				}
			} else if (value > currentRoot.value) {
				if (currentRoot.right != null) {
					currentRoot = currentRoot.right;
				} else {
					return false;
				}

			} else {
				return true;
			}
		}
		return false;
	}

	public int getMin() {
		TreeNode currentRoot = this;

		while (currentRoot.left != null) {
			currentRoot = currentRoot.left;
		}
		return currentRoot.value;
	}

	public void displayTreeInOrder() {
		if (this.left != null) {
			left.displayTreeInOrder();
		}

		System.out.print(this.value + " ");

		if (this.right != null) {
			right.displayTreeInOrder();
		}
	}

}
