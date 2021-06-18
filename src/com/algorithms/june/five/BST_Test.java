package com.algorithms.june.five;

public class BST_Test {

	public static void main(String[] args) {

		testCase1();
		testCase7();

	}

	private static void testCase7() {
		BST root = new BST(1);

		root.insert(2);
		root.insert(3);
		root.insert(4);

		root.printInOrder(root);

		System.out.println();
		System.out.println("This tree contains 1? " + root.contains(1));
		System.out.println("This tree contains 4? " + root.contains(4));

		System.out.println("Min Value = " + root.getMin());

		root = root.remove(1);
		System.out.println("Trying to delete 1" + root);
		System.out.println("After 1 delete -->");
		root.printInOrder(root);
	}

	private static void testCase1() {
		BST root = new BST(10);

		root.insert(5);
		root.insert(15);
		root.insert(2);
		root.insert(1);
		root.insert(5);
		root.insert(13);
		root.insert(12);
		root.insert(14);
		root.insert(22);

		System.out.println("InOrder -->");
		root.printInOrder(root);
		
		System.out.println("PreOrder -->");
		root.printPreOrder(root);
		System.out.println();

		System.out.println("PostOrder -->");
		root.printPostOrder(root);
		System.out.println();

		System.out.println();
		System.out.println("This tree contains 5? " + root.contains(5));
		System.out.println("This tree contains 15? " + root.contains(15));
		System.out.println("This tree contains 22? " + root.contains(22));
		System.out.println("This tree contains 8888? " + root.contains(8888));

		System.out.println("Min Value = " + root.getMin());

		System.out.println("Trying to delete 1" + root.remove(1));
		System.out.println("After 1 delete -->");
		root.printInOrder(root);

		
	}

}
