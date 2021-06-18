package com.algorithms.june.five;

public class TreeNodeTest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);

		root.insert(5);
		root.insert(15);
		root.insert(2);
		root.insert(1);
		root.insert(5);
		root.insert(13);
		root.insert(22);
		root.insert(12);
		root.insert(14);

		System.out.println("Printing tree nodes in order-->");
		root.printInOrder();
		System.out.println();
		System.out.println("Searching for 5 in tree. Is it there ? " + root.search(5));
		System.out.println("Searching for 12 in tree. Is it there ? " + root.search(12));
		System.out.println("Searching for 8888 in tree. Is it there ? " + root.search(8888));
	}

}
