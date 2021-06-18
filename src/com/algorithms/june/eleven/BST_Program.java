package com.algorithms.june.eleven;

import java.util.ArrayList;
import java.util.List;

public class BST_Program {

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
			BST current = this;
			while (current != null) {
				if (value < current.value) {
					if (current.left != null) {
						current = current.left;
					} else {
						current.left = new BST(value);
						break;
					}
				} else {
					if (current.right != null) {
						current = current.right;
					} else {
						current.right = new BST(value);
						break;
					}
				}
			}
			return this;
		}

		public boolean search(int value) {
			BST current = this;
			while (current != null) {
				if (value < current.value) {
					current = current.left;
				} else if (value > current.value) {
					current = current.right;
				} else {
					return true;
				}
			}
			return false;
		}

		public int getMin() {
			if (this.left != null) {
				return left.getMin();
			} else {
				return this.value;
			}
		}

		public BST remove(int value) {
			delete(value, null);
			return this;
		}

		public void delete(int value, BST parent) {
			BST current = this;
			while (current != null) {
				if (value < current.value) {
					parent = current;
					current = current.left;
				} else if (value > current.value) {
					parent = current;
					current = current.right;
				} else {
					if (current.left != null && current.right != null) {

						current.value = current.right.getMin();
						current.right.delete(current.value, current);

					} else if (parent == null) {
						if (current.left != null) {
							current.value = current.left.value;
							current.right = current.left.right;
							current.left = current.left.left;
						} else if (current.right != null) {
							current.value = current.right.value;
							current.left = current.right.left;
							current.right = current.right.right;
						} else {

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

		public void printInOrder() {
			if (this.left != null) {
				left.printInOrder();
			}

			System.out.print(this.value + " ");

			if (this.right != null) {
				right.printInOrder();
			}
		}

		public void printPreOrder() {
			System.out.print(this.value + " ");

			if (this.left != null) {
				left.printInOrder();
			}

			if (this.right != null) {
				right.printInOrder();
			}
		}

		public void printPostOrder() {
			if (this.left != null) {
				left.printInOrder();
			}

			if (this.right != null) {
				right.printInOrder();
			}

			System.out.print(this.value + " ");
		}

		@Override
		public String toString() {
			return "BST [value=" + value + ", left=" + left + ", right=" + right + "]";
		}

		public List<Integer> printReverseInOrder(List<Integer> list) {
			if (this.right != null) {
				right.printReverseInOrder(list);
			}
			list.add(this.value);
			System.out.print(this.value + " ");

			if (this.left != null) {
				left.printReverseInOrder(list);
			}
			return list;
		}
	}

	private static BST root;
	private static BST root2;

	public static void main(String[] args) {

		/*
		 * testPrints();
		 * 
		 * findKthLargestElement();
		 * 
		 * testSearchAndMin();
		 * 
		 * 
		 */
		testDelete();
		root2.printInOrder();

	}

	private static void testDelete() {
		root2 = new BST(10);
		root2.insert(5);
		root2.insert(15);

		root2.remove(10);

	}

	private static void testSearchAndMin() {
		System.out.println("Looking for 8888, is it there? " + root.search(8888));
		System.out.println("Looking for 1, is it there? " + root.search(1));

		System.out.println("Min tree value = " + root.getMin());
	}

	private static void findKthLargestElement() {
		System.out.println("Print tree in reverse inorder -->");
		List<Integer> descList = new ArrayList<Integer>();
		descList = root.printReverseInOrder(descList);
		int fifthLargestElement = 5;
		System.out.println("\n5th highest element from the tree = " + descList.get(fifthLargestElement));

		System.out.println();
	}

	private static void testPrints() {
		root = new BST(10);
		root.insert(5);
		root.insert(15);
		root.insert(7);
		root.insert(11);
		root.insert(2);
		root.insert(1);
		root.insert(17);
		root.insert(22);

		System.out.println("Print tree in order -->");
		root.printInOrder();
		System.out.println();

		System.out.println("Print tree pre-order -->");
		root.printPreOrder();
		System.out.println();

		System.out.println("Print tree post-order -->");
		root.printPostOrder();
		System.out.println();
	}

}
