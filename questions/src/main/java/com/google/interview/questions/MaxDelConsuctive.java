package com.google.interview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MaxDelConsuctive {
	public static void main(String[] args) {
		Scanner scanString = new Scanner(System.in);
		String fullNumber = "";
		int num_1 = scanString.nextInt();
		List<Integer> ints = new ArrayList();
		Stack<Digit> stack = new Stack();
		while (num_1 > 0) {
			int currentDigit = num_1 % 10;
			num_1 = num_1 / 10;
			Digit digit = new Digit(currentDigit);
			stack.push(digit);
		}
		while (stack.size() > 0) {
			ints.add(stack.pop().getDigit());
		}
		boolean stop = true;
		String num = "";
		for (int i = 0; i <= ints.size(); i++) {
			if (ints.get(i) == ints.get(i + 1) && stop) {
				num=num+(i+1);
				stop = false;
			} else {
				num = num + i;
			}

		}

		/*
		 * for (int i = 1; i <= stack.size(); i++) { int j = (stack.size() -
		 * i)-1; if (j <= stack.size()) { if
		 * (stack.peek().equals(stack.elementAt(j))) { System.out.println(
		 * "Match Found" + stack.peek()); } } }
		 */

	}
}