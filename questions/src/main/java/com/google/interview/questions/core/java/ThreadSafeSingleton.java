package com.google.interview.questions.core.java;

/**
 * Thread Safe Singleton using Static
 * field Initialization
 * 
 * @author VijaySidhu
 *
 */
public class ThreadSafeSingleton {

	private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();

	public static ThreadSafeSingleton getInstance() {
		return INSTANCE;
	}

	public void show() {
		System.out.println("Singleon using static initialization in Java");
	}
}