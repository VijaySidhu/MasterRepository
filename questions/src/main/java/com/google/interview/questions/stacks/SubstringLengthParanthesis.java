package com.google.interview.questions.stacks;

import java.util.Stack;

/**
 * O(n) 1) Create an empty stack and
 * push -1 to it. The first element of
 * stack is used to provide base for
 * next valid string.
 * 
 * 2) Initialize result as 0.
 * 
 * 3) If the character is '(' i.e.
 * str[i] == '('), push index 'i' to the
 * stack.
 * 
 * 2) Else (if the character is ')') a)
 * Pop an item from stack (Most of the
 * time an opening bracket) b) If stack
 * is not empty, then find length of
 * current valid substring by taking
 * difference between current index and
 * top of the stack. If current length
 * is more than result, then update the
 * result. c) If stack is empty, push
 * current index as base for next valid
 * substring.
 * 
 * 3) Return result.
 * 
 * @author VijaySidhu
 *Input: str = "(()()"

Initialize result as 0 and stack with one item -1.

For i = 0, str[0] = '(', we push 0 in stack

For i = 1, str[1] = '(', we push 1 in stack

For i = 2, str[2] = ')', currently stack has [-1, 0, 1], we pop
from the stack and the stack now is [-1, 0] and length of current
valid substring becomes 2 (we get this 2 by subtracting stack top 
from current index).
Since current length is more than current result, we update result.

For i = 3, str[3] = '(', we push again, stack is [-1, 0, 3].

For i = 4, str[4] = ')', we pop from the stack, stack becomes 
[-1, 0] and length of current valid substring becomes 4 (we get 
this 4 by subtracting stack top from current index). 
Since current length is more than current result, we update result. 
 */
public class SubstringLengthParanthesis {

	static int findMaxLen(String str) {
		int n = str.length();

		// Create a stack and push -1 as initial index to it.
		Stack<Integer> stk = new Stack();
		stk.push(-1);

		// Initialize result
		int result = 0;

		// Traverse all characters of given string
		for (int i = 0; i < n; i++) {
			// If opening bracket, push index of it
			if (str.charAt(i) == '(')
				stk.push(i);

			else // If closing bracket, i.e.,str[i] = ')'
			{
				// Pop the previous opening bracket's index
				stk.pop();

				// Check if this length formed with base of
				// current valid substring is more than max 
				// so far
				if (!stk.empty())
					result = Math.max(result, i - stk.peek());

				// If stack is empty. push current index as 
				// base for next valid substring (if any)
				else
					stk.push(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String str = "((()()";
		System.out.println(findMaxLen(str));

		str = "()(()))))";
		System.out.println(findMaxLen(str));
		/**
		 * Input: str = "(()()"

Initialize result as 0 and stack with one item -1.

For i = 0, str[0] = '(', we push 0 in stack

For i = 1, str[1] = '(', we push 1 in stack

For i = 2, str[2] = ')', currently stack has [-1, 0, 1], we pop
from the stack and the stack now is [-1, 0] and length of current
valid substring becomes 2 (we get this 2 by subtracting stack top 
from current index).
Since current length is more than current result, we update result.

For i = 3, str[3] = '(', we push again, stack is [-1, 0, 3].

For i = 4, str[4] = ')', we pop from the stack, stack becomes 
[-1, 0] and length of current valid substring becomes 4 (we get 
this 4 by subtracting stack top from current index). 
Since current length is more than current result, we update result. 
		 */

	}

}
