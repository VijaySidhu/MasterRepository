package com.google.interview.questions;

@SuppressWarnings("hiding")
public class Stack<Integer> {
	Integer total;
	Node first;

	class Node {
		Integer data;
		Node next;

		Node(Integer data) {
			this.data = data;
		}
	}

	/**
	 * Push Operation
	 */
	void push(Integer data) {
		if (null != data) {
			Node current = first;
			first = new Node(data);
			first.next = current;
		}
	}

	/**
	 * Pop operation
	 */
	public Integer pop() {
		Integer integer = null;
		if (first != null) {
			integer = first.data;
			first = first.next;
		}
		return integer;
	}

	public Integer peek() {
		Integer integer = null;
		if (first != null) {
			integer = first.data;
		}
		if (null == integer)
			return null;
		return integer;
	}

}
