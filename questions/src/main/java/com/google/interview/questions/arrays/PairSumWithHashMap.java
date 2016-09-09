package com.google.interview.questions.arrays;

/**
 * 1) Initialize Binary Hash Map M[] = {0, 0, ...} 
 * 2) Do following for each
 * element A[i] in A[] (a) If M[x - A[i]] is set then print the pair (A[i], x -
 * A[i]) (b) Set M[A[i]]
 * 
 * @author VijaySidhu
 *
 */
public class PairSumWithHashMap {
	private static final int MAX = 100000; // Max size of Hashmap

	static void printpairs(int arr[], int sum) {
		// Declares and initializes the whole array as false
		boolean[] binmap = new boolean[MAX];

		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (temp >= 0 && binmap[temp]) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			binmap[arr[i]] = true;
		}
	}

	// Main to test the above function
	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int n = 16;
		printpairs(A, n);
	}
}
