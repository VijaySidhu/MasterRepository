package com.google.interview.questions.linkedlist;

/**
 * O(n)
 *  
 * Keep track of previous of the
 * node to be deleted. First change the
 * next link of previous node and then
 * free the memory allocated for the
 * node.
 * 
 * @author VijaySidhu
 *
 */
public class DeleteAlternateNodes {

	Node head;

	// Iterative
	void deleteAlternate() {
		if (head == null) {
			return;
		}
		Node prev = head;
		Node now = head.next;
		while (prev != null && now != null) {
			prev.next = now.next;
			now = null;
			prev = prev.next;
			if (prev != null) {
				now = prev.next;
			}
		}
		System.out.println("Second List");
	}

	/* Utility functions */

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

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/*
	 * Drier program to test above
	 * functions
	 */
	public static void main(String args[]) {
		DeleteAlternateNodes llist = new DeleteAlternateNodes();

		/*
		 * Constructed Linked List is
		 * 1->2->3->4->5->null
		 */
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		System.out.println("Linked List before calling deleteAlt() ");
		llist.printList();

		llist.deleteAlternate();

		System.out.println("Linked List after calling deleteAlt() ");
		llist.printList();

	}

	static Node insertAtBegin(Node head, int data) {
		Node newHead = new Node(1);
		if (head == null) {
			head = newHead;
			return head;
		}
		newHead.next = head;
		return newHead;
	}

}
