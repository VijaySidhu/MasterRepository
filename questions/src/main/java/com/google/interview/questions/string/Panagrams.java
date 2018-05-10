package com.google.interview.questions.string;

import java.util.Scanner;

public class Panagrams {

	public static void main(String[] args) {
		//The quick brown fox jumps over the lazy dog
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println(Panagrams.isPangram(input));

	}

	static public boolean isPangram(String input) {
		boolean panagram = false;
		boolean[] charBM = new boolean[26];
		int aCharNum = (int) 'a';
		String inputLower = input.toLowerCase();
		for (int i = 0; i <= inputLower.length() - 1; i++) {
			if (inputLower.charAt(i) != ' ') {
				charBM[(((int) inputLower.charAt(i)) % aCharNum)] = true;
			}
		}

		for (int j = 0; j < 26; j++) {
			if (charBM[j] == false) {
				return panagram;
			} else {
				panagram = true;
			}

		}

		return panagram;
	}
}
