package com.algorithms.tree.binarysearchtree.iterative;

public class BST_Iterative_Main {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.insert(5).insert(4).insert(15).insert(2).insert(1).insert(5).insert(16).insert(13).insert(12).insert(14)
				.insert(22);

		System.out.println("Searching tree for 16. Exits? " + root.search(16));
		System.out.println("Searching tree for 1. Exits? " + root.search(1));
		System.out.println("Searching tree for 8888. Exits? " + root.search(8888));
		System.out.println("Searching tree for 4. Exits? " + root.search(4));

		System.out.println("Min value from tree = " + root.getMin());

		System.out.println("Trying to delete 1");
		root.delete(1);

		root.displayTreeInOrder();

		System.out.println("\nFinding closest value here--->");
		System.out.println("findClosestValueInBst of 17 is " + root.findClosestValueInBst(root, 17));
		System.out.println("findClosestValueInBst of 22 is " + root.findClosestValueInBst(root, 22));
		System.out.println("findClosestValueInBst of 11 is " + root.findClosestValueInBst(root, 11));
		System.out.println("findClosestValueInBst of 13 is " + root.findClosestValueInBst(root, 13));
		System.out.println("findClosestValueInBst of 9 is " + root.findClosestValueInBst(root, 9));
		
		System.out.println("Is this a valid BST = " + root.validateBST(root));
	}

}
