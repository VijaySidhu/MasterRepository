package com.google.interview.questions.linkedlist;

public class MergeTwoSortedLinkedList {

	public static Node mergeTwoLists(Node l1, Node l2) {
		Node head = new Node(0);
		Node p = head;

		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.data < l2.data) {
					p.next = l1;
					l1 = l1.next;
				} else {
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;
			} else if (l1 == null) {
				p.next = l2;
				break;
			} else if (l2 == null) {
				p.next = l1;
				break;
			}
		}

		return head.next;
	}

	/* Druver program to test above function */
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		Node node4 = new Node(1);
		Node node5 = new Node(1);
		Node node6 = new Node(2);

		node1.next = node2;
		node2.next = node3;

		node4.next = node5;
		node5.next = node6;

		Node result = MergeTwoSortedLinkedList.mergeTwoLists(node1, node4);
		MergeTwoSortedLinkedList.printList(result);

	}

	// Utility method to print a linked list
	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
