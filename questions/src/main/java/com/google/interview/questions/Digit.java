package com.google.interview.questions;

public class Digit {

	private int digit;

	public Digit(int digit) {
		this.digit = digit;
	}

	public int getDigit() {
		return digit;
	}

	public boolean equals(Digit digit) {
		if (this.getDigit() == digit.getDigit()) {
			return true;
		}
		return false;
	}

}
