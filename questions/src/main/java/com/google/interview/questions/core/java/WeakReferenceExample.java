package com.google.interview.questions.core.java;

import java.lang.ref.WeakReference;

/**
 * We tell JVM this is weak reference in
 * case if you run out of memory garbale
 * collect to this object
 * 
 * @author VijaySidhu
 *
 */
public class WeakReferenceExample {

	public void createWeakRefObject() {
		WeakReference<String> wr = new WeakReference<String>(new String("abc"));
	}
}
