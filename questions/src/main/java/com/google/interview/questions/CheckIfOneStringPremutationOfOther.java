package com.google.interview.questions;

public class CheckIfOneStringPremutationOfOther {

	public static void main(String[] args) {
		System.out.println("True Case::" + CheckIfOneStringPremutationOfOther.isPermutation("abc", "abc"));
		System.out.println("True Case::" + CheckIfOneStringPremutationOfOther.isPermutation("abc", "acb"));
		System.out.println("False Case::" + CheckIfOneStringPremutationOfOther.isPermutation("abc", "aec"));
	}

	public static boolean isPermutation(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		int[] letters = new int[256];

		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (--letters[c] < 0) {
				return false;
			}
		}
		return true;
	}

}
