package com.algorithms.june.twentynine;

public class LinkedList {

	public int value;
	public LinkedList next;

	public LinkedList(int value) {
		this.value = value;
		next = null;
	}

	@Override
	public String toString() {
		return "LinkedList [value=" + value + ", next=" + next + "]";
	}

}
