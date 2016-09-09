package com.google.interview.questions.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP {

	/**
	 * Faliure array
	 */

	private int index;
	private int symbolLength;

	int[] faliure;

	public KMP(String text, String pattern) {
		/**
		 * Pre construct Faliure array for pattern
		 */
		faliure = new int[pattern.length()];
		fail(pattern);
		/** find match **/
		int pos = posMatch(text, pattern);
		if (pos == -1)
			System.out.println("\nNo match found");
		else
			System.out.println("\nMatch found at index " + pos);
		index = pos;
		symbolLength = pattern.length();
	}

	private void fail(String pattern) {
		int n = pattern.length();
		faliure[0] = -1;
		for (int j = 1; j < n; j++) {
			int i = faliure[j - 1];

			while ((pattern.charAt(j) != pattern.charAt(i + 1)) && i >= 0)
				i = faliure[i];
			if (pattern.charAt(j) == pattern.charAt(i + 1))
				faliure[j] = i + 1;
			else
				faliure[j] = -1;
		}
	}

	/** Function to find match for a pattern **/
	private int posMatch(String text, String pat) {
		int i = 0, j = 0;
		int lens = text.length();
		int lenp = pat.length();
		while (i < lens && j < lenp) {
			if (text.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			} else if (j == 0)
				i++;
			else
				j = faliure[j - 1] + 1;
		}
		return ((j == lenp) ? (i - lenp) : -1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Knuth Morris Pratt Test\n");
		System.out.println("\nEnter Text\n");
		String text = br.readLine();
		System.out.println("\nEnter Pattern\n");
		String pattern = br.readLine();
		KMP kmp = new KMP(text, pattern);
	}

	public int getIndex() {
		return index;
	}

	public int getSymbolLength() {
		return symbolLength;
	}

}
