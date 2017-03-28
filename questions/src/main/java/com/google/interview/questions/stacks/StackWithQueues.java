package com.google.interview.questions.stacks;

import java.util.LinkedList;

/**
 * Time complexity : O(n)O(n). The
 * algorithm removes n elements and
 * inserts n + 1n+1 elements to q1 ,
 * where n is the stack size. This gives
 * 2n + 12n+1 operations. The operations
 * add and remove in linked lists has
 * O(1)O(1) complexity
 * 
 * @author VijaySidhu
 *
 */
// Add & Remove time complexity is O(1)
//Space complexity : O(1)O(1).
public class StackWithQueues {

	private LinkedList<Integer> q1 = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		q1.add(x);
		int sz = q1.size();
		while (sz > 1) {
			q1.add(q1.remove());
			sz--;
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		System.out.println(q1.remove());
	}

	public static void main(String[] args) {

		StackWithQueues sq = new StackWithQueues();
		sq.push(1);
		sq.push(2);
		sq.push(3);

		sq.pop();

	}

}
