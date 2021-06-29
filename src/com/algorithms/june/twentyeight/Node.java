package com.algorithms.june.twentyeight;

public class Node {

	public int value;
	public Node prev;
	public Node next;

	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", prev=" + prev + ", next=" + next + "]";
	}

}
