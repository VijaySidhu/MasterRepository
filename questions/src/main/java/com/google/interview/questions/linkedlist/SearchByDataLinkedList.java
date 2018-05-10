package com.google.interview.questions.linkedlist;

public class SearchByDataLinkedList {
	Node head;

	public boolean search(Node node, int data) {
		Node current = node;
		if (current == null) {
			return false;
		}
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	//Inserts a new node at the front of the list
	public void push(int new_data) {
		//Allocate new node and putting data
		Node new_node = new Node(new_data);

		//Make next of new node as head
		new_node.next = head;

		//Move the head to point to new Node
		head = new_node;
	}

	//Driver function to test the above functions
	public static void main(String args[]) {

		//Start with the empty list
		SearchByDataLinkedList llist = new SearchByDataLinkedList();

		/*
		 * Use push() to construct below list 14->21->11->30->10
		 */
		llist.push(10);
		llist.push(30);
		llist.push(11);
		llist.push(21);
		llist.push(14);

		if (llist.search(llist.head, 21))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
