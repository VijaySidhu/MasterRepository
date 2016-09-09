package com.google.interview.questions;

import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(StringCompression.compress(input));
	}

	private static String compress(String input) {
		char previous = input.charAt(0);
		int counter = 1;
		StringBuffer sb = new StringBuffer();
		sb.append(previous);
		for (int i = 1; i < input.length(); i++) {
			char current = input.charAt(i);
			if (previous == current) {
				++counter;
			} else {
				previous = current;
				sb.append(counter).append(current);
				counter = 1;
			}

		}
		sb.append(counter);
		return  sb.toString();
	}

}
