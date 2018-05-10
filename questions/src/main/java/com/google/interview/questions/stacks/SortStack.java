package com.google.interview.questions.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * The idea of the solution is to hold
 * all values in Function Call Stack
 * until the stack becomes empty. When
 * the stack becomes empty, insert all
 * held items one by one in sorted
 * order. Here sorted order is
 * important.
 * 
 * @author VijaySidhu
 *
 */
public class SortStack {
	public void sortStack(Stack<Integer> stack) {

		int no = stack.pop();
		if (stack.size() != 1) {
			sortStack(stack);
		}
		insert(stack, no);
	}

	private void insert(Stack<Integer> stack, int no) {

		if (stack.size() == 0) {
			stack.push(no);
		} else {
			int newPeakedNo = stack.peek();
			if (no >= newPeakedNo) {
				stack.push(no);
			} else {
				int newPoppedNo = stack.pop();
				insert(stack, no);
				stack.push(newPoppedNo);
			}
		}
	}

	public static void main(String args[]) {

		Stack<Integer> stack = new Stack();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println("Stack Before Sort : " + Arrays.toString(stack.toArray()));
		new SortStack().sortStack(stack);
		System.out.println("Stack After Sort : " + Arrays.toString(stack.toArray()));

	}

}
