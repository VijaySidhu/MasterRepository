package com.google.interview.questions.linkedlist;

/**
 * Method 1 (Use length of linked list)
 * 1) Calculate the length of Linked
 * List. Let the length be len. 2) Print
 * the (len – n + 1)th node from the
 * begining of the Linked List.
 * 
 * Method 2 // The key to this algorithm
 * is to set p1 and p2 apart by n-1
 * nodes initially // so we want p2 to
 * point to the (n-1)th node from the
 * start of the list // then we move p2
 * till it reaches the last node of the
 * list. // Once p2 reaches end of the
 * list p1 will be pointing to the nth
 * node // from the end of the list.
 * 
 * @author VijaySidhu
 *
 */
public class PrintNthFromEndOfLinkedList {
	Node head;

	// Method 1
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

	/**
	 * Method two
	 * 
	 * @param new_data
	 */

	void referencePointer(int n) {

		if (head == null || n < 1) {
			return;
		}
		Node temp = head;
		Node pointer1 = head;
		Node pointer2 = head;
		// loop to move pointer2
		while (n > 0 && pointer2.next != null) {
			// while moving p2 check if it becomes NULL, that is if it reaches the end
			// of the list. That would mean the list has less than n nodes, so its not 
			// possible to find nth from last, so return NULL.
			if (pointer2 == null) {
				return;
			}
			pointer2 = pointer2.next;
			n--;
		}
		// at this point p2 is (n-1) nodes ahead of p1. Now keep moving both forward
		// till p2 reaches the last node in the list.
		while (pointer2.next != null) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		System.out.println(pointer1.data);
	}

	/*
	 * Inserts a new Node at front of
	 * the list.
	 */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node &
		 * Put in the data
		 */
		Node new_node = new Node(new_data);

		/*
		 * 3. Make next of new Node as
		 * head
		 */
		new_node.next = head;

		/*
		 * 4. Move the head to point to
		 * new Node
		 */
		head = new_node;
	}

	/*
	 * Drier program to test above
	 * methods
	 */
	public static void main(String[] args) {
		PrintNthFromEndOfLinkedList llist = new PrintNthFromEndOfLinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);

		llist.printNthFromLast(4);
		llist.referencePointer(4);
	}

}
