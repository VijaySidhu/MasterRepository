package com.google.interview.questions.stacks;

import java.util.*;

/**
 * Algorithm 
 * 1. Scan the infix expression from left to right.
 * 2. If the scanned character is an operand, output it. 
 * 3. Else, …. 
 *   .3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is
 * empty), push it. …. .
 *    3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the precedence of the
 * operator residing on the top of the stack. Push the scanned operator to the stack. 
 * 4. If the scanned character is an ‘(‘, push it to the stack. 
 * 5. If the scanned character is an ‘)’, pop and output from the stack * until an ‘(‘ is encountered.
 * 6. Repeat steps 2-6 until infix expression is scanned. 
 * 7. Pop and output from the stack until it is not empty.
 * 
 * @author VijaySidhu
 */
public class InFixToPostFix {

	public static void main(String args[]) {

		String infix = "x-(y*a/b-(z+d*e)+c)/f";

		System.out.println("Infix : " + infix);
		System.out.println("Postfix : " + inf2postf(infix));

	}

	private static String inf2postf(String infix) {

		String postfix = "";
		Stack<Character> operator = new Stack<Character>();
		char popped;

		for (int i = 0; i < infix.length(); i++) {

			char get = infix.charAt(i);

			if (!isOperator(get))
				postfix += get;

			else if (get == ')')
				while ((popped = operator.pop()) != '(')
					postfix += popped;

			else {
				while (!operator.isEmpty() && get != '(' && precedence(operator.peek()) >= precedence(get))
					postfix += operator.pop();

				operator.push(get);
			}
		}
		// pop any remaining operator
		while (!operator.isEmpty())
			postfix += operator.pop();

		return postfix;
	}

	private static boolean isOperator(char i) {
		return precedence(i) > 0;
	}

	private static int precedence(char i) {

		if (i == '(' || i == ')')
			return 1;
		else if (i == '-' || i == '+')
			return 2;
		else if (i == '*' || i == '/')
			return 3;
		else
			return 0;
	}

}
