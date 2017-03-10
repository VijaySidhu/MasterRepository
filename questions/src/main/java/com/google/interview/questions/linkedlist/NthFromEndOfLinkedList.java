package com.google.interview.questions.linkedlist;

/**
 * Method 1 (Use length of linked list) 1) Calculate the length of Linked List.
 * Let the length be len. 2) Print the (len – n + 1)th node from the begining of
 * the Linked List.
 * 
 * @author VijaySidhu
 *
 */
public class NthFromEndOfLinkedList {
	Node head;

	void printNthFromLast(int n) {
		int len = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		if (len < n) {
			return;
		}
		temp = head;
		// Get nelen+1 node from begining
		for (int i = 1; i < len - n + 1; i++) {
			temp = temp.next;
		}
		System.out.println(temp.data);
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

	/* Drier program to test above methods */
	public static void main(String[] args) {
		NthFromEndOfLinkedList llist = new NthFromEndOfLinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);

		llist.printNthFromLast(4);
	}

}
