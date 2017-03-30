package com.google.interview.questions.core.java;

/**
 * Also known as static polymorphism
 * Number of parameters. Data type of
 * parameters. Sequence of Data type of
 * parameters
 * 
 * Thrown exceptions from methods are
 * also not considered when overloading
 * a method. So your overloaded method
 * throws the same exception, a
 * different exception or it simply does
 * no throw any exception; no effect at
 * all on method loading.
 * 
 * @author VijaySidhu
 *
 */
public class OverloadingExample {

	static public int add(int a, int b) {
		return a + b;
	}

	static public int add(int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String[] args) {
		System.out.println(add(11, 11));
		System.out.println(add(12, 12, 4));
	}
}
