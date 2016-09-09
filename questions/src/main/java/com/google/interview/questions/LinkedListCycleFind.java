package com.google.interview.questions;

public class LinkedListCycleFind {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void detectLoop(Node head) {
		Node slowPointer = head;
		Node fastPointer = head;
		while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				System.out.println("found");
				break;
			}

		}
		if (fastPointer.next == null) {
			System.out.println("there is no loop");
		}
		slowPointer = head;
		while (slowPointer != fastPointer) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}
		System.out.println(fastPointer.data);

	}

	public static void main(String[] args) {
		LinkedListCycleFind list = new LinkedListCycleFind();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);

		/**
		 * Create Loop
		 */
		head.next.next.next.next.next = head.next.next;
		list.detectLoop(head);

	}

}
