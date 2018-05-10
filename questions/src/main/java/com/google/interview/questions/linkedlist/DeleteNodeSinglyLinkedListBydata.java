package com.google.interview.questions.linkedlist;

public class DeleteNodeSinglyLinkedListBydata {

	Node head;

	void deleteNode(int key) {
		Node temp = head;
		Node prev = null;
		// If Head node itself holds key to be deleted
		if (temp != null && temp.data == key) {
			// Change head
			head = temp.next;
			return;
		}
		// Search for key to be deleted and keep track of previous node as we need to change temp.next
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		// If key is not present in the list
		if (temp == null)
			return;
		prev.next = temp.next;
	}

	/*
	 * This function prints contents of linked list starting from the given node
	 */
	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {
		DeleteNodeSinglyLinkedListBydata llist = new DeleteNodeSinglyLinkedListBydata();

		llist.push(7);
		llist.push(1);
		llist.push(3);
		llist.push(2);

		System.out.println("\nCreated Linked list is:");
		llist.printList();

		llist.deleteNode(1); // Delete node at position 4

		System.out.println("\nLinked List after Deletion at position 4:");
		llist.printList();
	}

}