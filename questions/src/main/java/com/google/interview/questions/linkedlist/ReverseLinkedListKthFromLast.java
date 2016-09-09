package com.google.interview.questions.linkedlist;

class Node {

	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

public class ReverseLinkedListKthFromLast {

	public Node reverseList(Node node) {
		Node prev = null;
		Node curr = node;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		Node head = node1;
		ReverseLinkedListKthFromLast r = new ReverseLinkedListKthFromLast();
		int k = 4;
		int nodeToTraverse = 5 - k;
		for (int i = 1; i <= nodeToTraverse; i++) {
			head.next = head.next;
		}
		Node reversedNode = r.reverseList(head.next);
		node1.next = reversedNode;

		while (node1 != null) {
			System.out.println(node1.data);
			node1 = node1.next;
		}

	}
}
