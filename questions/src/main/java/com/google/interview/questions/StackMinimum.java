package com.google.interview.questions;

public class StackMinimum extends Stack<Integer> {

	Stack<Integer> s2;

	public StackMinimum() {
		s2 = new Stack<Integer>();

	}

	/**
	 * Push Only if Super class stack data is greater than item
	 */
	public void push(Integer data) {
		if (null != data) {
			int item = data;
			if (null != super.peek() && item >= super.peek()) {
				s2.push(data);
			} else {
				super.push(data);
			}

		}
	}

	public Integer min() {
		return super.peek();
	}

	public static void main(String[] args) {
		StackMinimum stackMinimum = new StackMinimum();
		stackMinimum.push(4);
		stackMinimum.push(8);
		stackMinimum.push(3);
		System.out.println(stackMinimum.min());

	}

}
