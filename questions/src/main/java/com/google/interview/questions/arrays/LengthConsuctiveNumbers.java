package com.google.interview.questions.arrays;

import java.util.Arrays;
import java.util.HashSet;

//Find the length of maximum number of consecutive numbers jumbled up in an array. 
public class LengthConsuctiveNumbers {

	public static void main(String[] args) {
		int[] array = { 1,2, 95,94, 93, 1000, 2, 92, 1001 };
		System.out.println("Max continuous length = " + maxContinuousLength(array));
		System.out.println("Max continuous length = " + maxContinuousLength2(array));
	}
	/*
	 * Sorting Solution: Time Complexity = O(nlogn) Space Complexity = O(1)
	 */

	//Using sorting.
	public static int maxContinuousLength(int[] array) {
		int maxLength = 1, curLength = 1;
		Arrays.sort(array);
		int prev = array[0];
		for (int i = 1; i < array.length; i++) {
			if (prev == array[i] - 1) {
				curLength++;
			} else {
				maxLength = Math.max(maxLength, curLength);
				curLength = 1;
			}
			prev = array[i];
		}
		return maxLength;
	}

	/**
	 * HashSet Solution: Time Complexity = O(n) (amortized) Space Complexity =
	 * O(n)
	 */
	//using HashSet
	public static int maxContinuousLength2(int[] array) {
		int maxLength = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}
		for (Integer i : set) {
			if (!set.contains(i - 1)) {
				int curLength = 0;
				while (set.contains(i)) {
					i++;
					curLength++;
				}
				maxLength = Math.max(maxLength, curLength);
			}
		}
		return maxLength;
	}

}
