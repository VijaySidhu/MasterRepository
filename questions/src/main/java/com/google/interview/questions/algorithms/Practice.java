package com.google.interview.questions.algorithms;

import java.util.Stack;

public class Practice {

	public static void main(String[] args) {
		String infix = "x-(y*a/b-(z+d*e)+c)/f";

		System.out.println("Infix : " + infix);
		System.out.println("Postfix : " + infixToPost(infix));
	}

	public static String infixToPost(String input) {
		String postFix = "";
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		char popped;
		while (i < input.length()) {
			char ch = input.charAt(i);
			// If it is Operand just append it to resultant string
			if (precedence(ch) < 1) {
				postFix = postFix + ch;
			} else if (ch == ')') {
				// Pop from stack until left bracket comes
				while ((popped = stack.pop()) != '(') {
					postFix = postFix + popped;
				}
			} else {
				while (!stack.isEmpty() && ch != '(' && precedence(stack.peek()) >= precedence(ch)) {
					postFix = postFix + stack.pop();
				}
				stack.push(ch);
			}

			i++;
		}
		// Pop any remaining character
		while (!stack.isEmpty()) {
			postFix = postFix + stack.pop();

		}
		return postFix;
	}

	public static int precedence(char ch) {
		if (ch == '(' || ch == ')') {
			return 1;
		} else if (ch == '+' || ch == '-') {
			return 2;

		} else if (ch == '*' || ch == '/') {
			return 3;
		}
		return 0;
	}

}
