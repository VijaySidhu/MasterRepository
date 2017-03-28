package com.google.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class JumbledNumber {

	public static void main(String[] args) {
		JumbledNumber jumbledNumber = new JumbledNumber();
		jumbledNumber.getJumbledNumbers(20);

	}

	private List<String> getJumbledNumbers(int n) {
		List<String> jumbledNumbers = new ArrayList();
		for (int i = 1; i < n; i++) {
			if (i > 9) {
				String currentNumber = String.valueOf(i);
				for (int j = 0; j <= currentNumber.length() - 1;) {
					if (j > 0) {
						if (currentNumber.length() > 1 && (Integer.valueOf(currentNumber.charAt(j)) - Integer.valueOf(currentNumber.charAt(j - 1)) == 1) && (Integer.valueOf(currentNumber.charAt(j + 1)) - Integer.valueOf(currentNumber.charAt(j)) == 1)) {
							jumbledNumbers.add(currentNumber);
						}
						j++;
					}
				}
			}
		}

		return jumbledNumbers;
	}

}
