package com.google.interview.questions;

import java.util.Scanner;

public class FindIfStringHasUniqueChars {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		FindIfStringHasUniqueChars.unique(str);

	}

	public static boolean unique(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;

		}

		return false;
	}

}
