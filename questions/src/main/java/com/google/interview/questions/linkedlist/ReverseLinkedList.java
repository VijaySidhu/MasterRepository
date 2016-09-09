package com.google.interview.questions.linkedlist;

class ListNode {
	int data;
	ListNode next;
}

public class ReverseLinkedList {
	static public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode();
		ListNode listNode2 = new ListNode();
		ListNode listNode3 = new ListNode();
		listNode.data = 1;
		listNode2.data = 2;
		listNode3.data = 3;
		listNode.next = listNode2;
		listNode2.next = listNode3;
		ListNode resultList = ReverseLinkedList.reverseList(listNode);
		while (resultList != null) {
			System.out.println(resultList.data);
			resultList = resultList.next;
		}
	}

}
