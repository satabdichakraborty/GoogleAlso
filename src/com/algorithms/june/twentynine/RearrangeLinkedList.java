package com.algorithms.june.twentynine;

import java.util.ArrayList;
import java.util.List;

class LinkedListPair {
	LinkedList head;
	LinkedList tail;

	LinkedListPair(LinkedList head, LinkedList tail) {
		this.head = head;
		this.tail = tail;
	}

}

public class RearrangeLinkedList {

	private static LinkedList head;

	public static void main(String[] args) {
		head = createLinkedList(head);
		System.out.println("Original linked list : ");
		print(head);
		System.out.println("Linked list after rearranging : ");
		head = rearrangeLinkedList(head, 3);
		print(head);

	}

	public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
		LinkedList smallerLLHead = null;
		LinkedList smallerLLTail = null;
		LinkedList equalLLHead = null;
		LinkedList equalLLTail = null;
		LinkedList greaterLLHead = null;
		LinkedList greaterLLTail = null;

		LinkedList current = head;
		LinkedList prevNode = null;

		while (current != null) {
			if (current.value < k) {
				LinkedListPair smallerList = growTheLinkedList(smallerLLHead, smallerLLTail, current);
				smallerLLHead = smallerList.head;
				smallerLLTail = smallerList.tail;
			} else if (current.value == k) {
				LinkedListPair equalList = growTheLinkedList(equalLLHead, equalLLTail, current);
				equalLLHead = equalList.head;
				equalLLTail = equalList.tail;
			} else {
				LinkedListPair greaterList = growTheLinkedList(greaterLLHead, greaterLLTail, current);
				greaterLLHead = greaterList.head;
				greaterLLTail = greaterList.tail;
			}
			prevNode = current;
			current = current.next;
			prevNode.next = null;
		}
		// System.out.println("Smaller LL : smallerLLHead = [" + smallerLLHead + "] :
		// smallerLLTail = [" + smallerLLTail + "]");
		// print(smallerLLHead);
		// System.out.println("Equal LL : equalLLHead = [" + equalLLHead + "] :
		// equalLLTail = [" + equalLLTail + "]");
		// print(equalLLHead);
		// System.out.println("Greater LL : greaterLLHead+ [" + greaterLLHead + "] :
		// greaterLLTail = [" + greaterLLTail + "]");
		// print(greaterLLHead);

		LinkedListPair firstList = connectTwoLinkedLists(smallerLLHead, smallerLLTail, equalLLHead, equalLLTail);
		LinkedListPair finalList = connectTwoLinkedLists(firstList.head, firstList.tail, greaterLLHead, greaterLLTail);
		return finalList.head;
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

	private static LinkedListPair growTheLinkedList(LinkedList head, LinkedList tail, LinkedList node) {
		LinkedList newHead = head;
		LinkedList newTail = node;

		if (newHead == null) {
			newHead = node;
		}
		if (tail != null) {
			tail.next = node;
		}

		return new LinkedListPair(newHead, newTail);
	}

	private static LinkedListPair connectTwoLinkedLists(LinkedList headOne, LinkedList tailOne, LinkedList headTwo,
			LinkedList tailTwo) {
		LinkedList newHead = headOne == null ? headTwo : headOne;
		LinkedList newTail = tailTwo == null ? tailOne : tailTwo;
		
		if(tailOne != null) {
			tailOne.next = headTwo;
		}

		return new LinkedListPair(newHead, newTail);
	}

	private static LinkedList createLinkedList(LinkedList head) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(0);
		list.add(5);
		list.add(2);
		list.add(1);
		list.add(4);
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
