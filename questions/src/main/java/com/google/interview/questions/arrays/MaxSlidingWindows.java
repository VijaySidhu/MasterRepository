package com.google.interview.questions.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * O(n) method
 * 
 * We create a Dequeue, Qi of capacity
 * k, that stores only useful elements
 * of current window of k elements. An
 * element is useful if it is in current
 * window and is greater than all other
 * elements on left side of it in
 * current window. We process all array
 * elements one by one and maintain Qi
 * to contain useful elements of current
 * window and these useful elements are
 * maintained in sorted order. The
 * element at front of the Qi is the
 * largest and element at rear of Qi is
 * the smallest of current window
 */
public class MaxSlidingWindows {
	private static int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || a.length == 0)
			return new int[] {};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int[] result = new int[a.length - k + 1];
		int count = 0;
		for (int i = 0; i < a.length - k + 1; i++) {
			for (int j = i; j < i + k; j++) {
				pq.offer(a[j]);
			}
			result[count] = pq.poll();
			count = count + 1;
			pq.clear();
		}
		return result;

	}

	public static void main(String[] args) {
		int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindow(a, k)));
	}
}
