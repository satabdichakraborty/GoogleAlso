package com.algorithms.tree.binarysearchtree.recursive;

public class BSTreeMain {

	public static void main(String[] args) {
		BSTree tree = new BSTree(25);

		/*
		 * tree.insert(25); tree.insert(20); tree.insert(27); tree.insert(15);
		 * tree.insert(22); tree.insert(26); tree.insert(30); tree.insert(29);
		 * tree.insert(32);
		 */
		tree.insert(10);
		tree.insert(5);
		tree.insert(11);
		tree.insert(2);
		tree.insert(15);
		tree.insert(13);
		tree.insert(22);
		tree.insert(1);
		tree.insert(14);

		System.out.println();

		BSTreeNode found = tree.find(32);
		BSTreeNode found2 = tree.find(51);

		System.out.print("****Found 32 in the tree? ");
		System.out.print(found == null ? "No" : "Yes: " + found);
		System.out.println();
		System.out.print("****Found 51 in the tree? ");
		System.out.print(found2 == null ? "No" : found2);

		System.out.println();
		System.out.println("\nInorder Traversal results : ");
		tree.inOrderTraversal();

		System.out.println();

		System.out.println("\nMin value from tree : " + tree.getMin());
		System.out.println("\nMax value from tree : " + tree.getMax());

		System.out.println();

		//System.out.println("\nDeleted node with value 15: ");
		//tree.deleteNode(15);

		System.out.println();
		System.out.println("\nInorder Traversal results : ");
		tree.inOrderTraversal();

		// System.out.println("\nDeleted node with value 25: "); tree.deleteNode(25);

		System.out.println();
		System.out.println("\nInorder Traversal results : ");
		tree.inOrderTraversal();

		System.out.println();
		System.out.println("\nPreorder Traversal results : ");
		tree.preOrderTraversal();

		System.out.println();
		System.out.println("\nPostorder Traversal results : ");
		tree.postOrderTraversal();

		System.out.println();
		System.out.println("Validating BST = " + tree.validateBST());
	}

}
