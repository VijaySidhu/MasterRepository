package com.google.interview.questions;
/**
 * the complexity is O(n)
 * @author VijaySidhu
 *
 */
public class Encoder {

	public static void main(String[] args) {
		Encoder encoder = new Encoder();
		System.out.println(encoder.encode("p14akkkkkkkkpq"));
	}

	private String encode(String s) {

		StringBuilder builder = new StringBuilder();
		char[] A = s.toCharArray();
		int i = 0;
		while (i < A.length) {
			char c = A[i];
			int counter = 0;
			while (i < A.length && A[i] == c) {
				i++;
				counter++;
			}
			if (counter == 8) {
				builder.append(counter).append('x').append(c);
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}

}
