package com.algorithms.june.thirteen;

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

	public void insert(int target) {
		TreeNode current = this;

		while (current != null) {
			if (target < current.data) {
				if (current.left != null) {
					current = current.left;
				} else {
					current.left = new TreeNode(target);
					break;
				}

			} else {
				if (current.right != null) {
					current = current.right;
				} else {
					current.right = new TreeNode(target);
					break;
				}

			}
		}
	}

	public boolean search(int target) {
		TreeNode current = this;

		while (current != null) {
			if (target < current.data) {
				current = current.left;
			} else if (target > current.data) {
				current = current.right;
			} else {
				return true;
			}
		}

		return false;
	}

	public List<Integer> printInOrder(List<Integer> list) {
		if (this.left != null) {
			left.printInOrder(list);
		}

		list.add(this.data);

		if (this.right != null) {
			right.printInOrder(list);
		}
		return list;
	}

	public void printInOrder(TreeNode bst) {
		TreeNode current = bst;
		if (current.left != null) {
			left.printInOrder(current.left);
		}

		System.out.print(current.data + " ");

		if (current.right != null) {
			right.printInOrder(current.right);
		}

	}

	public int getMin() {
		TreeNode current = this;
		while (current != null && current.left != null) {
			current = current.left;
		}
		return current.data;
	}

	public int getMax() {
		TreeNode current = this;
		while (current != null && current.right != null) {
			current = current.right;
		}
		return current.data;
	}

	public void delete(int target) {
		delete(target, null);
	}

	public void delete(int target, TreeNode parent) {
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
					if (current.left != null) {
						current.data = current.left.data;
						current.left = current.left.left;
						current.right = current.left.right;

					} else if (current.right != null) {
						current.data = current.right.data;
						current.left = current.right.left;
						current.right = current.right.right;

					} else {
						System.err.println("Hey you are attempting to delete the only node in the tree");
						current = null;
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

public class BinarySearchTree {

	private static TreeNode root;

	public static void main(String[] args) {
		testInsert();
		testPrint();
		// testSearch(1);
		// testSearch(23);
		// testMinAndMax();
		// getKthHighestNode();
		// testTreeDeletion();

		// constructMinHeightBstFromList();
		
        /* O(n) time and O(d) space F*/
		// findClosestNodeInBst();

		System.out.println("Is this a valid BST? " + validateBST());
	}

	/* O(n) time and O(d) space F*/
	private static boolean validateBST() {
		return validateNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private static boolean validateNode(TreeNode subRoot, int minValue, int maxValue) {

		if (subRoot != null && (subRoot.data < minValue || subRoot.data >= maxValue)) {
			return false;
		}

		if (subRoot.left != null && !validateNode(subRoot.left, minValue, subRoot.data)) {
			return false;
		}

		if (subRoot.right != null && !validateNode(subRoot.right, subRoot.data, maxValue)) {
			return false;
		}
		return true;
	}

	private static void testInsert() {
		root = new TreeNode(10);
		root.insert(5);
		root.insert(15);
		root.insert(7);
		root.insert(17);
		root.insert(22);
		root.insert(1);
		root.insert(2);
	}

	private static void findClosestNodeInBst() {
		int target = 23;
		int value = closestNodeInBst(root, target, Integer.MAX_VALUE);
		System.out.println("Node closest to target [" + target + "] in the tree = " + value);

		target = 4;
		value = closestNodeInBst(root, target, Integer.MAX_VALUE);
		System.out.println("Node closest to target [" + target + "] in the tree = " + value);

		target = 16;
		value = closestNodeInBst(root, target, Integer.MAX_VALUE);
		System.out.println("Node closest to target [" + target + "] in the tree = " + value);

		target = 15;
		value = closestNodeInBst(root, target, Integer.MAX_VALUE);
		System.out.println("Node closest to target [" + target + "] in the tree = " + value);
	}

	private static int closestNodeInBst(TreeNode subRoot, int target, int closest) {
		if (subRoot == null) {
			return closest;
		}

		if (Math.abs(target - subRoot.data) < Math.abs(target - closest)) {
			closest = subRoot.data;
		}

		if (target < subRoot.data) {
			return closestNodeInBst(subRoot.left, target, closest);
		} else if (target > subRoot.data) {
			return closestNodeInBst(subRoot.right, target, closest);
		} else {
			return closest;
		}
	}

	private static void constructMinHeightBstFromList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(11);
		list.add(12);
		list.add(17);
		list.add(18);
		list.add(19);
		list.add(22);

		System.out.println("Constructing BST from the ordered list");
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
		TreeNode bst = constructMinHeightBst(list, 0, list.size() - 1, null);
		System.out.println("Printing newly constructed BST in order");
		bst.printInOrder(bst);
	}

	// O(n) time || O(n) space where n is the items in the list
	private static TreeNode constructMinHeightBst(List<Integer> list, int start, int end, TreeNode subRoot) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode bst = new TreeNode(list.get(mid));
		bst.left = constructMinHeightBst(list, start, mid - 1, bst);
		bst.right = constructMinHeightBst(list, mid + 1, end, bst);
		return bst;
	}

	private static void testTreeDeletion() {
		System.out.println("Attempting to delete left most leaf node");
		testDelete(1);
		System.out.println("Attempting to delete none existing node");
		testDelete(888);
		System.out.println("Attempting to delete right most leaf node");
		testDelete(22);
		System.out.println("Attempting to delete node with both left and right nodes");
		testDelete(5);
		System.out.println("Attempting to delete root node");
		testDelete(10);
		System.out.println("Attempting to delete root node");
		testDelete(7);
		System.out.println("Attempting to delete root node");
		testDelete(2);
		System.out.println("Attempting to delete root node");
		testDelete(15);
		System.out.println("Attempting to delete only node left in tree");
		testDelete(17);
	}

	private static void getKthHighestNode() {
		int kthNode = 6;
		List<Integer> list = new ArrayList<Integer>();

		list = root.printInOrder(list);
		System.out.println(kthNode + " highest element in the tree is " + list.get(list.size() - kthNode));

	}

	private static void testDelete(int target) {
		System.out.println("Attempting to delete " + target);
		root.delete(target);
		System.out.println("Tree after deleting " + target);
		testPrint();

	}

	private static void testMinAndMax() {
		System.out.println("Print Tree Min value : " + root.getMin());
		System.out.println("Print Tree Max value : " + root.getMax());
		System.out.println();

	}

	private static void testPrint() {
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("Print Tree in order");
		list = root.printInOrder(list);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

	private static void testSearch(int target) {
		System.out.print("Searching tree for " + target);
		System.out.println(" : " + root.search(target));

	}

}
