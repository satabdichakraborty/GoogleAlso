package com.algorithms.june.twentyeight;

import java.util.ArrayList;
import java.util.List;

public class MergeLinkedList {

	private static LinkedList head1;
	private static LinkedList head2;
	private static LinkedList headOfMergedList;

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(4);
		list1.add(6);
		list1.add(8);
		head1 = createLinkedList(head1, list1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(3);
		list2.add(5);
		list2.add(7);
		list2.add(9);
		list2.add(10);
		head2 = createLinkedList(head2, list2);
		System.out.println("Before Merge");
		print(head1);
		print(head2);
		headOfMergedList = mergeTwoLinkedLists(head1, head2);
		System.out.println("After Merge");
		print(headOfMergedList);
	}

	private static LinkedList mergeTwoLinkedLists(LinkedList head1, LinkedList head2) {
		LinkedList prev = null;
		LinkedList p1 = head1;
		LinkedList p2 = head2;
		while (p1 != null && p2 != null) {
			if (p1.value < p2.value) {
				prev = p1;
				p1 = p1.next;
			} else {
				if (prev != null) {
					prev.next = p2;
				}
				prev = p2;
				p2 = p2.next;
				prev.next = p1;
			}
		}
		if (p1 == null) {
			prev.next = p2;
		}

		return head1.value < head2.value ? head1 : head2;
	}

	private static void print(LinkedList head) {
		LinkedList current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}

	private static LinkedList createLinkedList(LinkedList head, List<Integer> list) {

		for (Integer value : list) {
			if (head == null) {
				head = new LinkedList(value);
			} else {
				LinkedList current = head;
				while (current.next != null) {
					current = current.next;
				}
				current.next = new LinkedList(value);
			}
		}
		return head;
	}

}
