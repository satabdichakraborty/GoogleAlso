package com.algorithms.june.twentyseven;

import java.util.ArrayList;
import java.util.List;

public class findLoopInLinkedList {

	private static LinkedList head;

	public static void main(String[] args) {
		createLoopedLinkedList();
		//printList();
		
		LinkedList loopNode = findLoop();
		System.out.println("Loopnode is = "+loopNode.value);
	}
	
	public static LinkedList findLoop() {
		LinkedList p1 = head.next;
		LinkedList p2 = head.next.next;
		while (p1 != p2) {
			//System.out.println("p1.value = ["+p1.value+"] : p2.value = ["+p2.value+"]");
			p1 = p1.next;
			p2 = p2.next.next;
		}
		System.out.println("Out of 1st loop :: p1.value = ["+p1.value+"] : p2.value = ["+p2.value+"]");
		p1 = head;
		while (p1 != p2) {
			//System.out.println("2nd loop :: p1.value = ["+p1.value+"] : p2.value = ["+p2.value+"]");
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println("Out of 2nd loop :: p1.value = ["+p1.value+"] : p2.value = ["+p2.value+"]");
		return p1;
	}

	private static void createLoopedLinkedList() {
		LinkedList current = null;
		LinkedList node4 = null;
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		for (Integer value : list) {
			if (head == null) {
				head = new LinkedList(value);
			} else {
				current = head;
				while (current.next != null) {
					if(current.value == 4) {
						//System.out.println("is this 4? "+current.value);
						node4 = current;
					}
					current = current.next;					
				}
				current.next = new LinkedList(value);				
			}
		}
		current.next = node4;
	}

	private static void printList() {
		LinkedList current = head;
		System.out.print("Head-->");
		while (current != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.print("null");
	}
}
