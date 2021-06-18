package com.algorithms.june.five;

import java.util.ArrayList;
import java.util.List;

public class BST {

	public int value;
	public BST left;
	public BST right;

	public BST(int value) {
		this.value = value;
	}

	public BST insert(int value) {
		if (value < this.value) {
			if (left != null) {
				this.left.insert(value);
			} else {
				this.left = new BST(value);
			}
		} else {
			if (right != null) {
				this.right.insert(value);
			} else {
				this.right = new BST(value);
			}
		}
		return this;
	}

	public boolean contains(int value) {
		if (value < this.value) {
			if (this.left != null) {
				return this.left.contains(value);
			}
		} else if (value > this.value) {
			if (this.right != null) {
				return this.right.contains(value);
			}
		} else {
			if (this.value == value) {
				return true;
			}
		}

		return false;
	}

	public int getMin() {
		if (this.left != null) {
			return this.left.getMin();
		} else {
			return this.value;
		}
	}

	public BST remove(int value) {
		return this.remove(this, value);
	}

	private BST remove(BST subTreeRoot, int value) {
		System.out.println("SubtreeRoot = " + subTreeRoot);

		if (subTreeRoot == null) {
			return subTreeRoot;
		}

		if (value < subTreeRoot.value) {

			subTreeRoot.left = remove(subTreeRoot.left, value);

		} else if (value > subTreeRoot.value) {

			subTreeRoot.right = remove(subTreeRoot.right, value);

		} else {
			if (subTreeRoot.left == null) {
				return subTreeRoot.right;
			} else if (subTreeRoot.right == null) {
				return subTreeRoot.left;
			} else {
				subTreeRoot.value = subTreeRoot.right.getMin();
				subTreeRoot.right = remove(subTreeRoot.right, subTreeRoot.value);

			}
		}
		return subTreeRoot;
	}

	public void printInOrder(BST subTreeRoot) {
		if (subTreeRoot.left != null) {
			subTreeRoot.left.printInOrder(subTreeRoot.left);
		}

		System.out.print(subTreeRoot.value + " ");

		if (subTreeRoot.right != null) {
			subTreeRoot.right.printInOrder(subTreeRoot.right);
		}
	}

	public void printPostOrder(BST subTreeRoot) {
		if (subTreeRoot.left != null) {
			subTreeRoot.left.printInOrder(subTreeRoot.left);
		}

		if (subTreeRoot.right != null) {
			subTreeRoot.right.printInOrder(subTreeRoot.right);
		}

		System.out.print(subTreeRoot.value + " ");
	}

	public void printPreOrder(BST subTreeRoot) {
		System.out.print(subTreeRoot.value + " ");

		if (subTreeRoot.left != null) {
			subTreeRoot.left.printInOrder(subTreeRoot.left);
		}

		if (subTreeRoot.right != null) {
			subTreeRoot.right.printInOrder(subTreeRoot.right);
		}
	}

	public boolean validateBst(BST tree) {
		List<Integer> bstValues = new ArrayList<Integer>();

		bstValues = getValue(tree, bstValues);

		boolean isSorted = false;
		int sortedPosition = bstValues.size();

		for (int i = sortedPosition; i > 0; i--) {
			isSorted = true;
			for (int j = 0; j < bstValues.size() - 1; j++) {
				if (bstValues.get(j) > bstValues.get(j + 1)) {
					isSorted = false;
				}
			}
		}
		return isSorted;
	}

	public List<Integer> getValue(BST tree, List<Integer> bstValues) {
		if (tree.left != null) {
			tree.left.getValue(tree.left, bstValues);
		}
		bstValues.add(this.value);

		if (tree.right != null) {
			tree.right.getValue(tree.right, bstValues);
		}

		return bstValues;
	}

	@Override
	public String toString() {
		return "BST [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
}