package com.algorithms.tree.binarysearchtree.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructMinHeightBST {

	private static BSTreeNode root;

	public static void main(String[] args) {
		List<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(5);
		array.add(7);
		array.add(10);
		array.add(13);
		array.add(14);
		array.add(15);
		array.add(22);

		root = minHeightBst(array);
		root.inOrderTraversal();
	}

	public static BSTreeNode minHeightBst(List<Integer> array) {
		return minHeightBst(array, 0, array.size() - 1);
	}

	private static BSTreeNode minHeightBst(List<Integer> array, int start, int end) {
		// System.out.println("At method beginning .. start = " + start + " : end = " +
		// end);
		if (end < start)
			return null;

		int mid = (start + end) / 2;// 4
		System.out.println("start = " + start + " : mid = " + mid + " : end = " + end);
		BSTreeNode bst = new BSTreeNode(array.get(mid)); // (0-8)-4, (0-3)-2, (0,2)-1
		bst.leftNode = minHeightBst(array, start, mid - 1); // (0-3)
		bst.rightNode = minHeightBst(array, mid + 1, end); // (5-8)
		System.out.println(bst);
		return bst;
	}

}
