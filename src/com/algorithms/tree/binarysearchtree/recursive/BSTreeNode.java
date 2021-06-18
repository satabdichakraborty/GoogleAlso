package com.algorithms.tree.binarysearchtree.recursive;

public class BSTreeNode {

	private int data;
	BSTreeNode leftNode;
	BSTreeNode rightNode;

	public BSTreeNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BSTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BSTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BSTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BSTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return "BSTreeNode [data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
	}

	public void insert(int newData) {
		if (newData < this.data) {
			if (leftNode == null) {
				System.out.println("Inserting new left node [" + newData + "] for node =[" + this.data + "]");
				leftNode = new BSTreeNode(newData);
			} else {
				leftNode.insert(newData);
			}
		} else {
			if (rightNode == null) {
				System.out.println("Inserting new right node [" + newData + "] for node =[" + this.data + "]");
				rightNode = new BSTreeNode(newData);
			} else {
				rightNode.insert(newData);
			}
		}
	}

	public BSTreeNode find(int value) {
		if (value == this.data) {
			return this;
		} else if (value < this.data) {
			if (leftNode == null) {
				return null;
			} else {
				return leftNode.find(value);
			}
		} else {
			if (rightNode == null) {
				return null;
			} else {
				return rightNode.find(value);
			}
		}
	}

	public void inOrderTraversal() {
		if (leftNode != null) {
			leftNode.inOrderTraversal();
		}

		System.out.print(this.data + ", ");

		if (rightNode != null) {
			rightNode.inOrderTraversal();
		}
	}

	public void preOrderTraversal() {
		System.out.print(this.data + " ");

		if (leftNode != null) {
			leftNode.preOrderTraversal();
		}

		if (rightNode != null) {
			rightNode.preOrderTraversal();
		}
	}

	public void postOrderTraversal() {
		if (leftNode != null) {
			leftNode.postOrderTraversal();
		}

		if (rightNode != null) {
			rightNode.postOrderTraversal();
		}

		System.out.print(this.data + " ");
	}

	public int getMin() {

		if (leftNode != null) {
			return leftNode.getMin();
		} else {
			return this.getData();
		}

	}

	public int getMax() {

		if (rightNode != null) {
			return rightNode.getMax();
		} else {
			return this.getData();
		}

	}

}
