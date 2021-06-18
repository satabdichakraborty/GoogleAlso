package com.algorithms.june.five;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

	public static void main(String[] args) {

		BST root = new BST(10);
		root.insert(5);
		root.insert(15);
		root.insert(2);
		root.insert(5);
		root.insert(1);
		root.insert(13);
		root.insert(22);
		root.insert(14);

		System.out.println();

		root.printInOrder(root);

		List<Integer> bstValues = new ArrayList<Integer>();
		bstValues = root.getValue(root, bstValues);

		System.out.println("bstValues -- ");
		for (Integer integer : bstValues) {
			System.out.print(integer + " ");
		}

		boolean res = root.validateBst(root);

		System.out.println("Is it a valid BST ? " + res);
	}

}
