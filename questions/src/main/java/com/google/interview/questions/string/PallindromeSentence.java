package com.google.interview.questions.string;

public class PallindromeSentence {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal, Panama! "));
		// abbacabba
		System.out.println(isPalindrome("#!@$% Ab !@%!@ B  !%@!%!@% a  1%!@% C  !@%!@% a  1%!@% B 1%!@% b @!#)(*) A "));

		System.out.println(isPalindrome("TEST"));
	}

	public static boolean isPalindrome(String s) {
		char a, b;
		int valA = 0, valB = 0;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			a = Character.toLowerCase(s.charAt(i));
			b = Character.toLowerCase(s.charAt(j));
			valA = a - 'a';
			valB = b - 'a';

			if (valA < 0 || valA >= 26) {
				i++;
			}
			if (valB < 0 || valB >= 26) {
				j--;
			}

			if ((valA >= 0 && valA < 26) && (valB >= 0 && valB < 26) && a != b) {
				return false;
			} else if ((valA >= 0 && valA < 26) && (valB >= 0 && valB < 26) && a == b) {
				i++;
				j--;
			}
		}
		return true;
	}
}
