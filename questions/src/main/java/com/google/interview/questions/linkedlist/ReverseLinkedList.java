package com.google.interview.questions.linkedlist;

class ListNode {
	int data;
	ListNode next;
}

public class ReverseLinkedList {
	ListNode head;

	// Iterative
	static public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	//Recursive
	public ListNode recursiveApproach(ListNode curr, ListNode prev) {
		if (curr.next == null) {
			head = curr;
			// update next to prev node
			curr.next = prev;
			return null;
		}
		ListNode next1 = curr.next;
		curr.next = prev;
		recursiveApproach(next1, curr);
		return head;
	}

	public static void main(String[] args) {
		ReverseLinkedList rv = new ReverseLinkedList();
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
		System.out.println("Recursive");
		ListNode listNoderecursive = new ListNode();
		ListNode listNode2recursive = new ListNode();
		ListNode listNode3recursive = new ListNode();
		listNoderecursive.data = 1;
		listNode2recursive.data = 2;
		listNode3recursive.data = 3;
		listNoderecursive.next = listNode2recursive;
		listNode2recursive.next = listNode3recursive;
		ListNode recursiveWay = rv.recursiveApproach(listNoderecursive, null);
		while (recursiveWay != null) {
			System.out.println(recursiveWay.data);
			recursiveWay = recursiveWay.next;
		}
	}

}
