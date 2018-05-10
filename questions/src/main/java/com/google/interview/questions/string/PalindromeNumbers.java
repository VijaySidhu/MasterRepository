package com.google.interview.questions.string;

public class PalindromeNumbers {

	public static void main(String[] args) {
		System.out.println(PalindromeNumbers.isPalindrome(121));
		// For Digital Clock loop from 0 to 59

		for (int i = 0; i <= 59; i++) {
			isPalindrome(i);

		}
	}

	static public boolean isPalindrome(int number) {
		int palindrome = number;
		int reverse = 0;
		while (palindrome != 0) {
			int remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
			palindrome = palindrome / 10;
		}
		if (number == reverse) {
			System.out.println(number);
			return true;
		}
		return false;
	}

}
