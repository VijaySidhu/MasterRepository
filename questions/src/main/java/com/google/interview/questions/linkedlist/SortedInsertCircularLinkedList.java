package com.google.interview.questions.linkedlist;

/**
 * Time Complexity: O(n)
 * 
 * @author VijaySidhu
 *
 */
public class SortedInsertCircularLinkedList {

	Node head;

	SortedInsertCircularLinkedList() {
		head = null;
	}

	void sortedInsert(Node newNode) {
		Node current = head;

		if (current == null) {
			newNode.next = newNode;
			head = newNode;
		} else if (current.data >= newNode.data) {

			// If value is smaller than head's value then we need to change next of last node;
			while (current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
			head = newNode;

		} else {

			// Locate node before insertion
			while (current.next != head && current.next.data < newNode.data) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;

		}
	}

	// Utility method to print a linked list
	void printList() {
		if (head != null) {
			Node temp = head;
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != head);
		}
	}

	// Driver code to test above
	public static void main(String[] args) {
		SortedInsertCircularLinkedList list = new SortedInsertCircularLinkedList();

		// Creating the linkedlist
		int arr[] = new int[] { 12, 56, 2, 11, 1, 90 };

		/* start with empty linked list */
		Node temp = null;

		/*
		 * Create linked list from the array arr[]. Created linked list will be
		 * 1->2->11->12->56->90
		 */
		for (int i = 0; i < 6; i++) {
			temp = new Node(arr[i]);
			list.sortedInsert(temp);
		}

		list.printList();
	}

}
