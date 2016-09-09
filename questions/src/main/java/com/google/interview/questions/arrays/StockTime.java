package com.google.interview.questions.arrays;

public class StockTime {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 90, 200, 110 };

		System.out.println(" Maximum diff is " + findDiff(arr));
	}

	public static int findDiff(int[] arr) {
		int diff = 0;
		int maxDiff = 0;
		int first = 0;
		int sec = 0;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arr[i] - arr[j] > maxDiff) {

					maxDiff = arr[i] - arr[j];
					first = arr[i];
					sec = arr[j];
				}

			}

		}

		System.out.println(" first " + first + "  " + "sec " + sec);

		return maxDiff;
	}
}
