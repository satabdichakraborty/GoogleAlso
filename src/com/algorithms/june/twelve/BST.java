package com.algorithms.june.twelve;

import java.util.ArrayList;
import java.util.List;

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	public TreeNode insert(int value) {
		TreeNode current = this;

		while (current != null) {
			if (value < current.data) {
				if (current.left != null) {
					current = current.left;
				} else {
					current.left = new TreeNode(value);
					break;
				}
			} else {

				if (current.right != null) {
					current = current.right;
				} else {
					current.right = new TreeNode(value);
					break;
				}
			}
		}
		return this;
	}

	public boolean search(int target) {
		TreeNode current = this;

		while (current != null) {
			if (target < current.data) {
				current = current.left;
			} else if (target > this.data) {
				current = current.right;
			} else {
				return true;
			}
		}
		return false;
	}

	public void printInOrder() {
		if (this.left != null) {
			left.printInOrder();
		}

		System.out.print(this.data + " ");

		if (this.right != null) {
			right.printInOrder();
		}
	}

	public int getMin() {

		if (this.left != null) {
			return left.getMin();
		} else {
			return this.data;
		}
	}

	public int getMax() {
		if (this.right != null) {
			return right.getMax();
		} else {
			return this.data;
		}
	}

	public TreeNode remove(int target) {
		delete(target, null);
		return this;
	}

	private void delete(int target, TreeNode parent) {
		TreeNode current = this;
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
					current.right.delete(current.data, current);

				} else if (parent == null) {
					if (current.right != null) {

						current.data = current.right.data;
						current.left = current.right.left;
						current.right = current.right.right;

					} else if (current.left != null) {

						current.data = current.left.data;
						current.left = current.left.left;
						current.right = current.left.right;

					} else {
						System.out.println("This is a single node tree .. hence do nothing");
						current = null;
					}
				} else if (parent.left == current) {
					parent.left = current.left != null ? current.left : current.right;

				} else if (parent.right == current) {
					parent.right = current.left != null ? current.left : current.right;
				}
				break;
			}
		} // end of while
	}

}

public class BST {

	private static TreeNode root;

	public static void main(String[] args) {
		// testInsertPrintMinMaxSearch();
		// testInsertDelete();
		// testConstructBSTfromSortedList();
		findClosestValueInBst();
		// validateBiranySearchTree();

	}

	private static void findClosestValueInBst() {
		TreeNode bst = new TreeNode(10);
		bst.insert(5).insert(2).insert(1).insert(7).insert(15).insert(11).insert(17).insert(22);

		System.out.println();
		bst.printInOrder();

		System.out.println("\nNode closest to 20 is " + closestInBiranySearchTree(bst, 20));
		System.out.println("\nNode closest to 3 is " + closestInBiranySearchTree(bst, 3));
		System.out.println("\nNode closest to 1 is " + closestInBiranySearchTree(bst, 1));
		System.out.println("\nNode closest to 16 is " + closestInBiranySearchTree(bst, 16));
		System.out.println("\nNode closest to 19 is " + closestInBiranySearchTree(bst, 19));

	}

	private static int closestInBiranySearchTree(TreeNode bst, int target) {
		return findClosestInBst(bst, target, Integer.MAX_VALUE);
	}

	private static int findClosestInBst(TreeNode subRoot, int target, int closest) {
		if (subRoot == null) {
			return closest;
		}

		if (Math.abs(target - subRoot.data) < Math.abs(target - closest)) {
			closest = subRoot.data;
		}

		if (target < subRoot.data) {
			return findClosestInBst(subRoot.left, target, closest);
		} else if (target > subRoot.data) {
			return findClosestInBst(subRoot.right, target, closest);
		} else {
			return closest;
		}
	}

	private static void testConstructBSTfromSortedList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(7);
		list.add(9);
		list.add(10);
		list.add(15);
		list.add(17);
		list.add(11);
		list.add(22);

		TreeNode bst = null;
		constructBST(list, bst);

	}

	private static void constructBST(List<Integer> list, TreeNode bst) {
		TreeNode tree = constructBST(list, 0, list.size() - 1, bst);
		System.out.println("Print newly constructed tree in order");
		tree.printInOrder();
	}

	private static TreeNode constructBST(List<Integer> list, int start, int end, TreeNode bst) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode tree = new TreeNode(list.get(mid));
		tree.left = constructBST(list, start, mid - 1, bst);
		tree.right = constructBST(list, mid + 1, end, bst);
		return tree;
	}

	private static void testInsertDelete() {
		root = new TreeNode(10);

		root.insert(5);
		root.insert(15);

		root.printInOrder();

		// root.remove(15);
		root.remove(5);
		root.printInOrder();
		System.out.println("Tree after deleting 5");
		root.remove(10);
		root.printInOrder();
		System.out.println("Tree after deleting 10");
		root.remove(15);
		root.printInOrder();
		System.out.println("Tree after deleting 15");

	}

	/*
	 * This method is testing Insert, Print Tree In order, Min value, Max value &
	 * search operation
	 */
	private static void testInsertPrintMinMaxSearch() {
		root = new TreeNode(10);

		root.insert(5);
		root.insert(15);

		root.printInOrder();

		System.out.println();
		System.out.println("Min value from tree = " + root.getMin());
		System.out.println("Max value from tree = " + root.getMax());

		System.out.println();
		System.out.println("This tree contains 8888 ? " + root.search(8888));
		System.out.println("This tree contains 5 ? " + root.search(5));

	}

}
