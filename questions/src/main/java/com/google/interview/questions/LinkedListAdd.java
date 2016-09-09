package com.google.interview.questions;

/**
 * Time Complexity: O(m + n) where m and n are number of nodes in first and
 * second lists respectively.
 * 
 * @author VijaySidhu
 *
 */
public class LinkedListAdd {

	static Node head1;
	static Node head2;

	static class Node {
		int data;

		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public Node addTwoLists(Node first, Node second) {
		int carry = 0;
		int sum = 0;
		Node temp = null;
		Node res = null;
		Node prev = null;

		while (first != null || second != null) {
			sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;
			temp = new Node(sum);
			/**
			 * If This is first Node Set it as Head
			 */

			if (res == null) {
				res = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;
			// Move first and second pointers to next nodes
			if (first != null) {
				first = first.next;
			}
			if (second != null) {
				second = second.next;
			}
		}

		if (carry > 0) {
			temp.next = new Node(carry);
		}

		return res;
	}

	/**
	 * Utility function to print linked list
	 */
	void printList(Node node) {
		while (node != null) {
			System.out.print(" " + node.data);
			node = node.next;
		}
	}

	public static void main(String[] args) {
		LinkedListAdd list = new LinkedListAdd();
		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);
		System.out.print("First List is ");
		list.printList(head1);

		// creating seconnd list
		list.head2 = new Node(8);
		list.head2.next = new Node(4);
		System.out.print("Second List is ");
		list.printList(head2);

		// add the two lists and see the result
		Node rs = list.addTwoLists(head1, head2);
		System.out.print("Resultant List is ");
		list.printList(rs);
	}
}
