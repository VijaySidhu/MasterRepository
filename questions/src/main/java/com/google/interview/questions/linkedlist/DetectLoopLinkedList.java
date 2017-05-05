package com.google.interview.questions.linkedlist;

/**
 * Implementation of Floyd’s
 * Cycle-Finding Algorithm: Time
 * Complexity: O(n) Auxiliary Space:
 * O(1)
 * 
 * @author VijaySidhu
 *
 */
public class DetectLoopLinkedList {
	Node head;

	// Find Cycle
	public boolean findAndRemoveCycle(Node node) {
		Node slowPointer = node;
		Node fastPointer = node.next;
		while (fastPointer != null && fastPointer.next != null) {
			if (slowPointer == fastPointer) {
				// Remove Loop
				return true;
			}
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;

		}
		return false;
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

	public static void main(String args[]) {
		DetectLoopLinkedList llist = new DetectLoopLinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;
		System.out.println("*Before Removal*");
		/*
		 * while (llist.head.next !=
		 * null) {
		 * System.out.println(llist.head
		 * .data); llist.head =
		 * llist.head.next; }
		 */

		Node noCycle = Practice.findAndRemoveCycle(llist.head);
		while (noCycle != null) {
			System.out.println(noCycle.data);
			noCycle = noCycle.next;
		}
	}
}
