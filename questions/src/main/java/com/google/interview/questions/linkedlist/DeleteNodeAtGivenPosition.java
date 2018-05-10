package com.google.interview.questions.linkedlist;

public class DeleteNodeAtGivenPosition {

	Node head;

	public void deleteNodeAtPosition(int position) {

		if (head == null) {
			return;
		}

		Node temp = head;
		int counter = 0;

		if (position == 0) {
			head = temp.next;
			return;
		}

		// Find prev node of node to be deleted
		while (temp != null && counter < position - 1) {
			temp = temp.next;
			counter++;
		}

		// If position is more than numbder of nodes
		if (temp == null || temp.next == null) {
			return;
		}

		temp.next = temp.next.next;
		//temp.next = next;

	}

	/*
	 * This function prints contents of linked list starting from the given node
	 */
	public void printList(Node nodes) {
		if(nodes == null){
			Node tnode = nodes;
		}
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
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

	/*
	 * Drier program to test above functions. Ideally this function should be in
	 * a separate user class. It is kept here to keep code compact
	 */
	public static void main(String[] args) {
		/* Start with the empty list */
		DeleteNodeAtGivenPosition llist = new DeleteNodeAtGivenPosition();

		llist.push(7);
		llist.push(1);
		llist.push(3);
		llist.push(2);
		llist.push(8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList(llist.head);
	    
	   // llist.printList(Practice.deleteNode(llist.head, 3));

		llist.deleteNodeAtPosition(3); // Delete node at position 4

		System.out.println("\nLinked List after Deletion at position 4: ");
		llist.printList(null);
	}

}
