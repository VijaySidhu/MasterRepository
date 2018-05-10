package com.google.interview.questions.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfArrays {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 2, 2, 5, 6 };
		int[] arr2 = { 0, 1, 2, 2, 2, 6, 5 };
		int[] result = IntersectionOfArrays.intersection(arr, arr2);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	static int[] intersection(int[] arr, int[] arr2) {
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (!seen.containsKey(i))
				seen.put(i, 0);
			seen.put(i, seen.get(i) + 1);
		}
		for (int j : arr2) {
			if (seen.containsKey(j) && seen.get(j) > 0) {
				intersection.add(j);
				seen.put(j, seen.get(j) - 1);
			}
		}
		int[] result = new int[intersection.size()];
		for (int k = 0; k < result.length; k++) {
			result[k] = intersection.get(k);
		}
		return result;
	}
}
