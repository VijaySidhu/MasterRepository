package com.google.interview.questions.linkedlist;

class NodeDel {
	int data;
	NodeDel next;

	public NodeDel(int data) {
		this.data = data;
	}
}

public class DeleteNode {
	public static void main(String[] args) {
		DeleteNode del = new DeleteNode();
		NodeDel node1 = new NodeDel(1); //At 0
		NodeDel node2 = new NodeDel(2);//At 1
		NodeDel node3 = new NodeDel(3);//At 2
		NodeDel node4 = new NodeDel(4);//At 3
		NodeDel node5 = new NodeDel(5);//At 4
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		NodeDel head = del.delete(node1, 2);
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

	public NodeDel delete(NodeDel head, int pos) {
		NodeDel trackNode = head;
		int counter = 0;
		if (pos == 0) {
			return head.next;
		}
		while (head != null && counter < pos) {
			head = head.next;
			counter++;
		}
		head.data = head.next.data;
		head.next = head.next.next;
		return trackNode;
	}

}
