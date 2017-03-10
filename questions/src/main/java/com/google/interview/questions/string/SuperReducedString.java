package com.google.interview.questions.string;

import java.util.Scanner;

/**
 * Shil has a string, , consisting of lowercase English letters. In one
 * operation, he can delete any pair of adjacent letters with same value. For
 * example, string "" would become either "" or "" after operation.
 * 
 * @author VijaySidhu
 *
 */
public class SuperReducedString {

	public static void main(String[] args) {
		// Input aaabccddd
		Scanner stdin = new Scanner(System.in);
		StringBuilder s = new StringBuilder(stdin.nextLine());
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				// string builder delete method end index in exlusive
				s.delete(i - 1, i + 1);
				i = 0;
			}
		}
		if (s.length() == 0)
			System.out.println("Empty String");
		else
			System.out.println(s);
	}
}
