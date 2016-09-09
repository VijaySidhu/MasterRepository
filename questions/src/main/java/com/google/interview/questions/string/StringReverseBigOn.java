package com.google.interview.questions.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Big O(N)
 * 
 * @author VijaySidhu
 *
 */
public class StringReverseBigOn {

	public static void main(String[] args) {
		System.out.println(StringReverseBigOn.reverse("DADA"));
	}

	private static String reverse(String input) {
		String reversed = "";
		Set<Character> set = new HashSet<>();
		for (int i = input.length() - 1; i >= 0; i--) {
			if (!set.contains(input.charAt(i))) {
				set.add(input.charAt(i));
				reversed = reversed + input.charAt(i);
			}
		}
		return reversed;
	}

}
