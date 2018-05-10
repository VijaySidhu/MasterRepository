package com.google.interview.questions.linkedlist;

class NodeAtBegin {

	int data;

	NodeAtBegin next;

	public NodeAtBegin(int data) {
		this.data = data;
	}
}

public class InsertAtBeginning {
	public static void main(String[] args) {
		InsertAtBeginning begin = new InsertAtBeginning();
		NodeAtBegin head = new NodeAtBegin(2);
		NodeAtBegin headNext = new NodeAtBegin(3);
		head.next = headNext;
		NodeAtBegin result = begin.insertAtBegin(head, 1);
		while (result != null) {
			System.out.println(result.data);
			result = result.next;
		}

	}

	NodeAtBegin insertAtBegin(NodeAtBegin head, int data) {
		NodeAtBegin newHead = new NodeAtBegin(1);
		if (head == null) {
			head = newHead;
			return head;
		}
		newHead.next = head;
		return newHead;
	}

}
