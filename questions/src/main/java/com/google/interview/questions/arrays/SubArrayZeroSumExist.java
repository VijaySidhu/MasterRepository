package com.google.interview.questions.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayZeroSumExist {

	static boolean isSubArrayExist(int arr[]) {

		Map<Integer, Integer> sumMAp = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = +arr[i];
			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (arr[i] == 0 || sum == 0 || sumMAp.get(sum) != null) {
				return true;
			}
			sumMAp.put(sum, i);
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 2, -3, 1, 6 };
		if (isSubArrayExist(arr))
			System.out.println("Found a subarray with 0 sum");
		else
			System.out.println("No Subarray with 0 sum");
	}

}
