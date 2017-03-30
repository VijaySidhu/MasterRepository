package com.google.interview.questions.core.java;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * WeakHashMap works like a normal
 * HashMap but uses WeakReference for
 * keys, which means if the key object
 * doesn't have any reference then both
 * key/value mapping will become
 * eligible for garbage collection.
 * 
 * @author VijaySidhu
 *
 */
public class WeakHashMapWork {
	public static void main(String[] args) {
		// Ask the user how many Widget objects they want to create
		// Remember each Widget takes a little over 1MB
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many objects do you want to create ?");
		int count = scanner.nextInt();

		Map<Integer, WeakReference<Widget>> weakWidgets = new HashMap<Integer, WeakReference<Widget>>();

		System.out.println("Creating " + count + " widgets as weak references.");

		for (int i = 0; i < count; i++) {
			weakWidgets.put(i, new WeakReference<Widget>(new Widget(i)));
		}

		// Here's how we access items from a WeakReference
		for (int i = 0; i < count; i++) {
			WeakReference<Widget> weakRef = weakWidgets.get(i);
			Widget ww = weakRef.get();
			// Find out if the WeakWidget is still there or has it been GC'd
			if (ww == null) {
				System.out.println("Oops WeakWidget " + i + " was garbage collected.");
			} else {
				System.out.println("Awesome WeakWidget " + i + " is still around. Let's use it");
			}
		}

	}
}

class Widget {

	private byte buff[];
	private int id;

	public Widget(int id) {
		//Each Widget object takes approximately 1MB
		this.buff = new byte[1024 * 1000];
		this.id = id;
	}
}