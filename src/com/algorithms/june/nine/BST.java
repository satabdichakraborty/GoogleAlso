package com.algorithms.june.nine;

import java.util.ArrayList;
import java.util.List;

public class BST {

	public int value;
	BST left;
	BST right;

	BST(int data) {
		this.value = data;
	}

	/*
	 * public boolean delete(int target) { BST current = this; BST parentNode =
	 * this; boolean isDeleted = false;
	 * 
	 * while (current != null) { if (target < current.value) { parentNode = current;
	 * current = current.left; } else if (target > current.value) { parentNode =
	 * current; current = current.right; } else { // Actual delete happens here if
	 * target is found in the tree if (parentNode != null) { if (current.left !=
	 * null && current.right != null) { parentNode.value =
	 * parentNode.right.getMin(); parentNode.right.delete(parentNode.value); } else
	 * if (parentNode.right == current) { parentNode.right = current.left != null ?
	 * current.left : current.right; isDeleted = true; return isDeleted; } else if
	 * (parentNode.left == current) { parentNode.left = current.left != null ?
	 * current.left : current.right; isDeleted = true; return isDeleted; } } else if
	 * (parentNode == null) { // This is for the root node deletion case if
	 * (current.left != null) { current.value = current.left.value; current.right =
	 * current.left.right; current.left = current.left.left; } else if
	 * (current.right != null) { current.value = current.right.value; current.left =
	 * current.right.left; current.right = current.right.right; } else { // Single
	 * node tree do nothing } } break; } } return isDeleted; }
	 */

	public BST remove(int value) {
		remove(value, null);
		return this;
	}

	public void remove(int value, BST parentNode) {
		BST current = this;

		while (current != null) {
			if (value < current.value) {
				parentNode = current;
				current = current.left;
			} else if (value > current.value) {
				parentNode = current;
				current = current.right;
			} else {
				// Actual delete happens here if target is found in the tree
				if (current.left != null && current.right != null) {
					current.value = current.right.getMin();
					current.right.remove(current.value);
				} else if (parentNode == null) {
					// This is for the root node deletion case
					if (current.left != null) {
						current.value = current.left.value;
						current.right = current.left.right;
						current.left = current.left.left;
					} else if (current.right != null) {
						current.value = current.right.value;
						current.left = current.right.left;
						current.right = current.right.right;
					} else {
						// Single node tree do nothing
					}
				} else if (parentNode.left == current) {
					parentNode.left = current.left != null ? current.left : current.right;
				} else if (parentNode.right == current) {
					parentNode.right = current.left != null ? current.left : current.right;
				}

				break;
			}
		}
	}

	public int findClosetValueInBst(int target) {
		return findClosetValue(target, this, Integer.MAX_VALUE);
	}

	public int findClosetValue(int target, BST subRoot, int closest) {
		if (Math.abs(target - subRoot.value) < Math.abs(target - closest)) {
			closest = subRoot.value;
		}

		if (target < subRoot.value && subRoot.left != null) {
			return subRoot.left.findClosetValue(target, subRoot.left, closest);
		} else if (target > subRoot.value && subRoot.right != null) {
			return subRoot.right.findClosetValue(target, subRoot.right, closest);
		} else {
			return closest;
		}

	}

	public void insert(int data) {
		BST current = this;

		while (current != null) {
			if (data < current.value) {
				if (current.left == null) {
					current.left = new BST(data);
					break;
				} else {
					current = current.left;
				}
			} else {
				if (current.right == null) {
					current.right = new BST(data);
					break;
				} else {
					current = current.right;
				}
			}
		}
	}

	public boolean search(int data) {
		BST current = this;

		while (current != null) {
			if (data < current.value) {
				current = current.left;
			} else if (data > current.value) {
				current = current.right;
			} else {
				return true;
			}
		}
		return false;
	}

	public int getMin() {
		BST current = this;
		while (current != null) {
			if (current.left != null) {
				current = current.left;
			} else {
				return current.value;
			}
		}
		return Integer.MIN_VALUE;
	}

	/*
	 * public void insert(int data) {
	 * 
	 * if (data < this.data) { if (this.left != null) { left.insert(data); } else {
	 * left = new TreeNode(data); } } else { if (this.right != null) {
	 * right.insert(data); } else { right = new TreeNode(data); } }
	 * 
	 * }
	 */
	public void ptrintInOrder() {

		if (this.left != null) {
			left.ptrintInOrder();
		}

		System.out.print(this.value + " ");

		if (this.right != null) {
			right.ptrintInOrder();
		}
	}

	public void ptrintPreOrder() {

		System.out.print(this.value + " ");

		if (this.left != null) {
			left.ptrintInOrder();
		}

		if (this.right != null) {
			right.ptrintInOrder();
		}
	}

	public void ptrintPostOrder() {

		if (this.left != null) {
			left.ptrintInOrder();
		}

		if (this.right != null) {
			right.ptrintInOrder();
		}
		System.out.print(this.value + " ");
	}

	public int findKthLargestElement(int k) {
		List<Integer> descOrderElements = new ArrayList<Integer>();
		descOrderElements = reverseInOrder(descOrderElements);

		for (Integer integer : descOrderElements) {
			System.out.print(integer + " ");
		}

		return descOrderElements.get(descOrderElements.size() - k);
	}

	private List<Integer> reverseInOrder(List<Integer> array) {
		if (this.right != null) {
			right.reverseInOrder(array);
		}
		array.add(this.value);

		if (this.left != null) {
			left.reverseInOrder(array);
		}
		return array;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + value + ", left=" + left + ", right=" + right + "]";
	}

}
