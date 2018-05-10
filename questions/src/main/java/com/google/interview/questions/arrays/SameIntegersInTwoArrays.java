package com.google.interview.questions.arrays;

/**
 * So how about we calculate both the
 * sum and the sum of squares for the
 * two arrays and if they match we
 * declare the array to be the same.
 * Note that this would work if and only
 * if both the arrays have integers and
 * exactly the same number of elements.
 * We can detect very easily whether
 * both the arrays have same number of
 * elements or not while finding the sum
 * and sum of squares for both the
 * arrays. Our total time for the
 * algorithm is O(n+n) = O(2n) = O(n).
 * 
 * @author VijaySidhu
 *
 */
public class SameIntegersInTwoArrays {

	static boolean isSameIntegers(int[] arrayOne, int[] arrayTwo) {

		if (arrayOne.length != arrayTwo.length) {
			return false;
		}

		if (sumSquares(arrayOne) == sumSquares(arrayTwo)) {
			return true;
		}
		return false;

	}

	static int sumSquares(int[] arr) {
		int square = 0;
		int sum = 0;
		for (int i = 0; i <= arr.length - 1; i++) {
			square = arr[i] * arr[i];
			sum = sum + square;
			square = 0;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, -1, -2 };
		int[] array2 = { 1, 2, 3, -1, -2 };
		System.out.println(isSameIntegers(array1, array2));
	}

}
