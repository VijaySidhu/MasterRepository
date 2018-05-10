package com.google.interview.questions.linkedlist;

/**
 * Implementation of Floyd’s Cycle-Finding Algorithm: Time Complexity: O(n)
 * Auxiliary Space: O(1)
 * 
 * @author VijaySidhu
 *
 */
public class DetectLoopLinkedList {
	Node head;

	int detectLoop() {
		Node slowPointer = head;
		Node fastPointer = head;
		while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		if (slowPointer == fastPointer) {
			return 1;
		}
		return 0;
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	public static void main(String args[]) {
		DetectLoopLinkedList llist = new DetectLoopLinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;

		llist.detectLoop();
	}
}
