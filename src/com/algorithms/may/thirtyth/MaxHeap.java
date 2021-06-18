package com.algorithms.may.thirtyth;

public class MaxHeap {

	private static int[] heap;
	private static int size;

	public static void main(String[] args) {

		/*
		 * heap = new int[10]; printHeap(); insertAtMaxHeap(20); insertAtMaxHeap(18);
		 * insertAtMaxHeap(16); insertAtMaxHeap(22); insertAtMaxHeap(24);
		 * insertAtMaxHeap(4); insertAtMaxHeap(14); insertAtMaxHeap(40); printHeap();
		 */
		
		heap = new int[10];
		insertAtMinHeap(20);
		insertAtMinHeap(18);
		insertAtMinHeap(16);
		insertAtMinHeap(22);
		insertAtMinHeap(24);
		insertAtMinHeap(4);
		insertAtMinHeap(14);
		insertAtMinHeap(40);
		printHeap();

	}

	private static boolean isEmpty() {
		return size == 0;
	}

	private static void insertAtMaxHeap(int data) {
		if (isEmpty()) {
			heap[0] = data;
			size++;
		} else {
			heap[size++] = data;
			heapifyMaxHeap(size - 1);
		}
	}

	private static void heapifyMaxHeap(int childIndex) {

		int newItem = heap[childIndex];
		int parentIndex = getParentIdx(childIndex);

		while (childIndex > 0 && newItem > heap[getParentIdx(childIndex)]) {
			heap[childIndex] = heap[getParentIdx(childIndex)];
			childIndex = getParentIdx(childIndex);
		}

		heap[childIndex] = newItem;
	}
	
	private static void insertAtMinHeap(int data) {
		if (isEmpty()) {
			heap[0] = data;
			size++;
		} else {
			heap[size++] = data;
			heapifyMinHeap(size - 1);
		}
	}

	private static void heapifyMinHeap(int childIndex) {

		int newItem = heap[childIndex];
		int parentIndex = getParentIdx(childIndex);

		while (childIndex > 0 && newItem < heap[getParentIdx(childIndex)]) {
			heap[childIndex] = heap[getParentIdx(childIndex)];
			childIndex = getParentIdx(childIndex);
		}

		heap[childIndex] = newItem;
	}

	private static int getParentIdx(int child) {
		return (child - 1) / 2;
	}

	private static void printHeap() {
		System.out.println("Heap --> ");
		for (int i : heap) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
