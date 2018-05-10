package com.google.interview.questions.core.java;

/**
 * Enum is type-safe 
 * Enum has its own namespace. 
 * By default Constants
 * defined are final
 * Java compiler automatically generates static values() method for every enum in java
 * Java enums are immutable object instances
 * @author VijaySidhu
 *
 */
public enum Currency {

	PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

	private int denomination;

	private Currency(int denomination) {
		this.denomination = denomination;
	}

	public int getDenomination() {
		return denomination;
	}

}
