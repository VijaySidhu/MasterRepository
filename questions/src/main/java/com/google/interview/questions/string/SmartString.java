package com.google.interview.questions.string;

import java.util.Scanner;

public class SmartString {
	public static void main(String args[]) {
//Featuring stylish rooms and moornings for recreation boats, Room Mate Aitana is a designer hotel built in 2013 on an island in the IJ River in Amsterdam.
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		char[] c = str.toCharArray();
		char[] d = new char[str.length()];
		String[] sa = str.split(" ");
		int count = 0;
		for (int i = 0; i < 30; i++) {
			if (c[i] == ' ') {
				count = count + 1;

			}

		}

		for (int j = 0; j <= count; j++) {

			System.out.println(sa[j]);
		}
	}
}
