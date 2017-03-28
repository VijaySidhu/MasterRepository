package com.google.interview.questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. Sort all array elements in
 * increasing order. The purpose of
 * sorting is to make sure that all
 * divisors of an element appear before
 * it.
 */
/*
 * 2. Create an array divCount[] of same
 * size as input array. divCount[i]
 * stores size of divisible subset
 * ending with arr[i] (In sorted array).
 * The minimum value of divCount[i]
 * would be 1.
 */
/*
 * 3. Traverse all array elements. For
 * every element, find a divisor arr[j]
 * with largest value of divCount[j] and
 * store the value of divCount[i] as
 * divCount[j] + 1.
 * 
 * @author VijaySidhu
 *
 */
public class LargestDivisibleSubset {

	public static List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return result;

		Arrays.sort(nums);

		int[] t = new int[nums.length];
		int[] index = new int[nums.length];
		Arrays.fill(t, 1);
		Arrays.fill(index, -1);

		int max = 0;
		int maxIndex = -1;

		for (int i = 0; i < t.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0 && t[j] + 1 > t[i]) {
					t[i] = t[j] + 1;
					index[i] = j;
				}
			}

			if (max < t[i]) {
				max = t[i];
				maxIndex = i;
			}
		}

		int i = maxIndex;
		while (i >= 0) {
			result.add(nums[i]);
			i = index[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 16, 7, 8, 4 };
		List<Integer> res = largestDivisibleSubset(arr);
		for (Integer in : res) {

			System.out.print(in+" ");

		}

	}
}
