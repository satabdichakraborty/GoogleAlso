package com.algorithms.june.twentyseven;

public class LinkedList {

	int value;
	LinkedList next;

	LinkedList(int value) {
		this.value = value;
		this.next = null;
	}

	@Override
	public String toString() {
		return "LinkedList [value=" + value + ", next=" + next + "]";
	}

}
