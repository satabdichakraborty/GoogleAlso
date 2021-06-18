package com.algorithms.june.nine;

import java.util.ArrayList;
import java.util.List;

public class TreeMain {

	private static BST root;

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(5);
		list.add(7);
		list.add(10);
		list.add(11);
		list.add(15);
		list.add(17);
		list.add(22);

		BST bst = constructBSTWithMinHeith(list);

		System.out.println("Min Heith bst from ordered list -->");
		bst.ptrintInOrder();
		System.out.println();

		// System.out.println("\n8th Largest Element = " +
		// bst.findKthLargestElement(8));
		// System.out.println("\n2nd Largest Element = " +
		// bst.findKthLargestElement(2));

		System.out.println("\n8th Largest Element = " + findKthLargestValueInBst(bst, 8));

		// testDeletion(bst);

		// testCase1();

	}

	public static int findKthLargestValueInBst(BST tree, int k) {
		List<Integer> list = new ArrayList<Integer>();
		list = reverseInOrder(list, tree);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		return list.get(list.size() - k);
	}

	private static List<Integer> reverseInOrder(List<Integer> list, BST tree) {
		if (tree.right != null) {
			reverseInOrder(list, tree.right);
		}

		list.add(tree.value);

		if (tree.left != null) {
			reverseInOrder(list, tree.left);
		}
		return list;
	}

	private static void testDeletion(BST bst) {
		System.out.println("Trying to delete 1. Result = ");
		bst.remove(10);
		// System.out.println("Trying to delete 7. Result = " + bst.delete(7));
		// System.out.println("Trying to delete 22. Result = " + bst.delete(22));
		// System.out.println("Trying to delete 2. Result = " + bst.delete(2));

		// System.out.println("Tree after delete-->");
		// bst.ptrintInOrder();
		// System.out.println();
	}

	private static void testCase1() {
		root = new BST(10);
		root.insert(2);
		root.insert(5);
		root.insert(7);
		root.insert(13);
		root.insert(15);
		root.insert(22);

		System.out.println("In order -->");
		root.ptrintInOrder();

		System.out.println("\nPre order -->");
		root.ptrintPreOrder();

		System.out.println("\nPost order -->");
		root.ptrintPostOrder();

		System.out.println();
		System.out.println("Looking for 22.. is it there? " + root.search(22));

		System.out.println();
		System.out.println("Looking for 8888.. is it there? " + root.search(8888));

		System.out.println("Get min = " + root.getMin());

		System.out.println("findClosetValueInBst of 16 = " + root.findClosetValueInBst(16));
		System.out.println("findClosetValueInBst of 23 = " + root.findClosetValueInBst(23));
		System.out.println("findClosetValueInBst of 4 = " + root.findClosetValueInBst(4));
	}

	private static BST constructBSTWithMinHeith(List<Integer> list) {
		BST treeNode = null;
		return constructBSTWithMinHeith(0, list.size() - 1, treeNode, list);
	}

	private static BST constructBSTWithMinHeith(int start, int end, BST treeNode, List<Integer> list) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		treeNode = new BST(list.get(mid));
		treeNode.left = constructBSTWithMinHeith(start, mid - 1, treeNode.left, list);
		treeNode.right = constructBSTWithMinHeith(mid + 1, end, treeNode.right, list);
		return treeNode;
	}

}
