package com.algorithms.june.Fifteen;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
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
				if (current.left == null) {
					current.left = new TreeNode(target);
					break;
				} else {
					current = current.left;
				}
			} else {
				if (current.right == null) {
					current.right = new TreeNode(target);
					break;
				} else {
					current = current.right;
				}
			}
		}
	}

	public List<Integer> printTreeInOrder(List<Integer> list) {
		if (this.left != null) {
			left.printTreeInOrder(list);
		}

		list.add(this.data);

		if (this.right != null) {
			right.printTreeInOrder(list);
		}

		return list;
	}

	public List<Integer> printTreePreOrder(List<Integer> list) {
		list.add(this.data);
		if (this.left != null) {
			left.printTreeInOrder(list);
		}

		if (this.right != null) {
			right.printTreeInOrder(list);
		}

		return list;
	}

	public List<Integer> printTreePostOrder(List<Integer> list) {
		if (this.left != null) {
			left.printTreeInOrder(list);
		}

		if (this.right != null) {
			right.printTreeInOrder(list);
		}
		list.add(this.data);

		return list;
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
						current.right = current.right.right;
						current.left = current.right.left;
					} else {
						System.err.println("Trying to delete single root node tree!!");
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

	public void delete(int target) {
		delete(target, null);
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

	public int findClosestNodeValue(int target) {
		int val = findClosestNodeValue(this, target, Integer.MAX_VALUE);
		return val;
	}

	private int findClosestNodeValue(TreeNode subRoot, int target, int closest) {
		if (subRoot == null) {
			return closest;
		}

		if ((Math.abs(target - subRoot.data)) < (Math.abs(target - closest))) {
			closest = subRoot.data;
		}

		if (target < subRoot.data && subRoot.left != null) {
			return findClosestNodeValue(subRoot.left, target, closest);
		} else if (target > subRoot.data && subRoot.right != null) {
			return findClosestNodeValue(subRoot.right, target, closest);
		} else {
			return closest;
		}
	}

	public boolean validateBST() {
		return validateNodesInBST(this, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private boolean validateNodesInBST(TreeNode treeNode, int minValue, int maxValue) {
		if (treeNode.data < minValue || treeNode.data >= maxValue) {
			return false;
		}
		
		if(treeNode.left != null && !validateNodesInBST(treeNode.left, minValue, treeNode.data)) {
			return false;
		}
		
		if(treeNode.right != null && !validateNodesInBST(treeNode.right, treeNode.data, maxValue)) {
			return false;
		}
		return true;
	}

}

public class BinarySearchTree {

	private static TreeNode root;

	public static void main(String[] args) {

		testInsert();
		testPrint();
		testSearch();
		testMin();
		testMax();
		// testDelete();
		testClosestNode();
		testBSTValidation();
		testKthHighestNode();
	}

	private static void testKthHighestNode() {
		
		List<Integer> list = new ArrayList<Integer>();
		
		if(root != null) {
			list = root.printTreeInOrder(list);
		}
		int kthHighest = 5;
		System.out.println(list.get(list.size() - kthHighest));		
	}

	private static void testBSTValidation() {
		boolean isValid = false;
		if (root != null) {
			isValid = root.validateBST();
		}
		
		System.out.println("Is this a valid BST ? "+isValid);
	}

	private static void testClosestNode() {
		int result = -1;
		int target = 15;

		if (root != null) {
			result = root.findClosestNodeValue(target);
		}

		System.out.println("Value closest to target [" + target + "] is node [" + result + "]");

		target = 16;

		if (root != null) {
			result = root.findClosestNodeValue(target);
		}

		System.out.println("Value closest to target [" + target + "] is node [" + result + "]");

		target = 13;

		if (root != null) {
			result = root.findClosestNodeValue(target);
		}

		System.out.println("Value closest to target [" + target + "] is node [" + result + "]");

	}

	private static void testMax() {
		int max = Integer.MAX_VALUE;
		if (root != null) {
			max = root.getMax();
		}
		System.out.println("Max value from tree = " + max);
	}

	private static void testMin() {
		int min = Integer.MIN_VALUE;
		if (root != null) {
			min = root.getMin();
		}
		System.out.println("Min value from tree = " + min);
	}

	private static void testDelete() {
		int target = 21;
		if (root != null) {
			root.delete(target);
		}
		target = 1;
		if (root != null) {
			root.delete(target);
		}
		target = 11;
		if (root != null) {
			root.delete(target);
		}
		target = 15;
		if (root != null) {
			root.delete(target);
		}
		target = 5;
		if (root != null) {
			root.delete(target);
		}
		target = 10;
		if (root != null) {
			root.delete(target);
		}
		target = 7;
		if (root != null) {
			root.delete(target);
		}
		target = 2;
		if (root != null) {
			root.delete(target);
		}
		target = 17;
		if (root != null) {
			root.delete(target);
		}
		target = 12;
		if (root != null) {
			root.delete(target);
		}
		testPrint();
	}

	private static void testSearch() {

		int target = 21;
		System.out.println();
		System.out.println("Looking for target [" + target + "] in the tree. Does it exists? = " + searchTree(target));

		target = 1;
		System.out.println("Looking for target [" + target + "] in the tree. Does it exists? = " + searchTree(target));

		target = 8888;
		System.out.println("Looking for target [" + target + "] in the tree. Does it exists? = " + searchTree(target));

		target = 5;
		System.out.println("Looking for target [" + target + "] in the tree. Does it exists? = " + searchTree(target));

	}

	private static void testPrint() {
		printTree();
	}

	private static void testInsert() {
		insert(10);
		insert(5);
		insert(15);
		insert(2);
		insert(7);
		insert(1);
		insert(12);
		insert(17);
		insert(11);
		insert(21);
	}

	private static boolean searchTree(int target) {
		boolean isFound = false;
		if (root != null) {
			isFound = root.search(target);
		}
		return isFound;
	}

	private static void printTree() {
		List<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			list = root.printTreeInOrder(list);
		}

		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	}

	private static void insert(int data) {
		if (root == null) {
			root = new TreeNode(data);
		} else {
			root.insert(data);
		}
	}

}
