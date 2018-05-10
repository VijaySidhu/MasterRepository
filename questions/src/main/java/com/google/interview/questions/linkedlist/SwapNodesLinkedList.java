package com.google.interview.questions.linkedlist;

public class SwapNodesLinkedList {
	Node head;

	public void swapNodes(int x, int y) {
		// Nothing to do
		if (x == y) {
			return;
		}
		// traverse linked list & find x & previous nodes
		Node prevX = null, currX = head;
		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}

		Node prevY = null, currY = head;
		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}

		// if x or y is not present, nothing to do
		if (currX == null || currY == null) {
			return;
		}

		// if x is not head of linked list
		if (prevX != null) {
			prevX.next = currY;
		} else {
			head = currY;
		}
		if (prevY != null) {
			prevY.next = currX;
		} else {
			head = currX;
		}

		// Swap next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}

	/* Function to add Node at beginning of list. */
	public void push(int new_data) {
		/* 1. alloc the Node and put the data */
		Node new_Node = new Node(new_data);

		/* 2. Make next of new Node as head */
		new_Node.next = head;

		/* 3. Move the head to point to new Node */
		head = new_Node;
	}

	/*
	 * This function prints contents of linked list starting from the given Node
	 */
	public void printList() {
		Node tNode = head;
		while (tNode != null) {
			System.out.print(tNode.data + " ");
			tNode = tNode.next;
		}
	}

	/* Druver program to test above function */
	public static void main(String[] args) {
		SwapNodesLinkedList llist = new SwapNodesLinkedList();

		/*
		 * The constructed linked list is: 1->2->3->4->5->6->7
		 */
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		System.out.print("\n Linked list before calling swapNodes() ");
		llist.printList();
		llist.swapNodes(4, 3);
		System.out.print("\n Linked list after calling swapNodes() ");
		llist.printList();
	}
}
