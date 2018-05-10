package com.google.interview.questions;

public class StackLinkedList<T> {

	private int total;
	private Node first;

	class Node {
		T element;
		Node next;

		public Node(T element) {
			this.element = element;
		}
	}

	/**
	 * Implement Push
	 */
	public StackLinkedList<T> push(T element) {
		if (first != null) {
			Node current = first;
			first = new Node(element);
			first.next = current;
			total++;
			return this;
		}
		return null;
	}

	/**
	 * Implement Pop
	 */
	public T pop() {
		if (first != null) {
			T element = first.element;
			first = first.next;
			total--;
			return element;
		}
		throw new NullPointerException("Stack is null");
	}

	/**
	 * Implement Peek
	 */
	public T peek(){
		if(first!=null){
			T element = first.element;
			return element;
		}
		throw new NullPointerException("Stack is Null ");
	}
}
