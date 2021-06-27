package com.algorithms.june.twentysix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SinglyLinkedList {

	private static SinglyNode head;
	private static SinglyNode headOne;
	private static SinglyNode headTwo;

	public static void main(String[] args) {
		// testInsertPrintDelete();
		// testRemoveDupsASC();
		// testRemoveDupsRandom();
		// removeKthNodeFromEnd();
		sumOfTwoLinkedList();
	}

	private static void sumOfTwoLinkedList() {
		List<Integer> listOne = new ArrayList<Integer>();
		listOne.add(1);
		listOne.add(2);
		listOne.add(3);
		listOne.add(4);
		headOne = createLinkedList(headOne, listOne);
		testPrint(headOne);
		List<Integer> listTwo = new ArrayList<Integer>();
		listTwo.add(9);
		listTwo.add(9);
		listTwo.add(9);
		listTwo.add(9);
		headTwo = createLinkedList(headTwo, listTwo);
		testPrint(headTwo);
		SinglyNode headOfSum = null;
		headOfSum = sumTwoLists(headOne, headTwo);
		testPrint(headOfSum);
	}

	private static SinglyNode sumTwoLists(SinglyNode headOne, SinglyNode headTwo) {
		SinglyNode currentOne = headOne;
		SinglyNode currentTwo = headTwo;
		SinglyNode headOfSum = null;

		int carry = 0;

		while (currentOne != null || currentTwo != null || carry != 0) {
			int digitOne = currentOne != null ? currentOne.data : 0;
			int digitTwo = currentTwo != null ? currentTwo.data : 0;
			int sum = digitOne + digitTwo + carry;
			int digit = sum % 10;
			carry = sum / 10;
			headOfSum = insert(digit, headOfSum);

			currentOne = currentOne != null ? currentOne.next : null;
			currentTwo = currentTwo != null ? currentTwo.next : null;

		}
		return headOfSum;
	}

	private static SinglyNode createLinkedList(SinglyNode head, List<Integer> list) {
		for (Integer integer : list) {
			head = insert(integer, head);
		}
		return head;
	}

	private static void removeKthNodeFromEnd() {
		int removeTarget = 3;
		testInsert();
		System.out.println("Before removing [" + removeTarget + "] from the end");
		testPrint(head);
		removeKthNodeFromEnd(removeTarget);
		System.out.println("After removing [" + removeTarget + "] from the end");
		testPrint(head);
	}

	private static void removeKthNodeFromEnd(int removeTarget) {
		SinglyNode one = head;
		SinglyNode two = head;
		SinglyNode previous = null;
		int temp = 1;
		while (temp < removeTarget) {
			temp++;
			one = one.next;
		}
		while (one.next != null) {
			one = one.next;
			previous = two;
			two = two.next;
		}
		previous.next = two.next;
	}

	private static void testInsertPrintDelete() {
		testInsert();
		testPrint(head);
		testDelete();

	}

	private static void testRemoveDupsRandom() {
		createLinkedListWithDupsDSC();
		System.out.println("Before removing dups");
		testPrint(head);
		removeDupsDSC();
		System.out.println("After removing dups");
		testPrint(head);

	}

	private static void removeDupsDSC() {
		SinglyNode current = head;
		Set<Integer> nums = new TreeSet<Integer>();
		while (current != null) {
			nums.add(current.data);
			current = current.next;
		}

		head = null;
		for (Integer data : nums) {
			insert(data);
		}

	}

	private static void createLinkedListWithDupsDSC() {
		int bound = 7;
		Random random = new Random();
		int i = 10;
		while (i > 0) {
			int target = random.nextInt(bound);
			insert(target);
			i--;
		}
	}

	private static void testRemoveDupsASC() {
		createLinkedListWithDupsASC();
		System.out.println("Before removing dups");
		testPrint(head);
		removeDupsASC();
		System.out.println("After removing dups");
		testPrint(head);
	}

	private static void removeDupsASC() {
		SinglyNode current = head;
		SinglyNode previous = null;

		while (current != null) {
			previous = current;
			while (current.next != null && current.data == current.next.data) {
				current = current.next;
			}

			previous.next = current.next;
			current = current.next;
		}
	}

	private static void createLinkedListWithDupsASC() {
		int target = 1;
		insert(target);
		target = 1;
		insert(target);
		target = 1;
		insert(target);
		target = 2;
		insert(target);
		target = 3;
		insert(target);
		target = 3;
		insert(target);
		target = 4;
		insert(target);
		target = 4;
		insert(target);
		target = 4;
		insert(target);
		target = 5;
		insert(target);
		target = 6;
		insert(target);
		target = 6;
		insert(target);
	}

	private static void testDelete() {
		int target = 1;
		System.out.println("Before deleting target = [" + target + "]");
		testPrint(head);

		delete(target);

		System.out.println("After deleting target = [" + target + "]");
		testPrint(head);

		target = 4;
		System.out.println("Before deleting target = [" + target + "]");
		testPrint(head);

		delete(target);

		System.out.println("After deleting target = [" + target + "]");
		testPrint(head);
	}

	private static void delete(int target) {
		SinglyNode current = head;
		SinglyNode previous = null;
		while (current.next != null && current.data != target) {
			previous = current;
			current = current.next;
		}

		if (previous == null) {
			head = head.next;
		} else {
			previous.next = current.next;
		}
	}

	private static void testPrint(SinglyNode head) {
		SinglyNode current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println("null");
	}

	private static void testInsert() {

		for (int i = 0; i < 10; i++) {
			insert(i);
		}
	}

	private static void insert(int data) {
		SinglyNode current = head;
		if (head == null) {
			head = new SinglyNode(data);
		} else {
			current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new SinglyNode(data);
		}
	}

	private static SinglyNode insert(int data, SinglyNode head) {
		SinglyNode current = head;
		if (head == null) {
			head = new SinglyNode(data);
		} else {
			current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new SinglyNode(data);
		}
		return head;
	}

}
