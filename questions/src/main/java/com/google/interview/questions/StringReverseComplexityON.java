package com.google.interview.questions;

import java.util.HashSet;
import java.util.Set;

public class StringReverseComplexityON {

	public static void main(String[] args) {
		System.out.println(StringReverseComplexityON.reverseString("abc"));
	}

	private static String reverseString(String input) {
		if (null == input || input.length() < 1) {
			return input;
		}

		Set<Character> alreadyPrintedChar = new HashSet<>();
		String reversed = "";
		for (int index = input.length() - 1; index >= 0; index--) {
			Character ch = input.charAt(index);
			if (false == alreadyPrintedChar.contains(ch)) {
				alreadyPrintedChar.add(ch);
				reversed = reversed + ch;
			}

		}
		return reversed;
	}

}
