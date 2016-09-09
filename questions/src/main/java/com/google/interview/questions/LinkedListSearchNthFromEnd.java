package com.google.interview.questions;

/**
 * Maintain two pointers – reference pointer and main pointer. Initialize both
 * reference and main pointers to head. First move reference pointer to n nodes
 * from head. Now move both pointers one by one until reference pointer reaches
 * end. Now main pointer will point to nth node from the end. Return main
 * pointer.
 * 
 * @author VijaySidhu
 *
 */
public class LinkedListSearchNthFromEnd {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		/**
		 * This Push method add node at front of the list
		 */
		linkedList.push(20);
		linkedList.push(30);
		linkedList.push(40);
		linkedList.push(50);
		// Print
		linkedList.printNthFromLast(1);
		// Delete
		linkedList.deleteNode(linkedList.head);
	}
}
